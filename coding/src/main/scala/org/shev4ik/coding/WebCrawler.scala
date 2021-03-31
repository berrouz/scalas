package org.shev4ik.coding

import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import akka.util.Timeout
import org.shev4ik.coding.web._

import scala.concurrent.duration._
import scala.concurrent.{Future, Promise}
import scala.language.higherKinds
import scala.util.{Failure, Success, Try}

object WebCrawlerApp extends App {
  implicit val system: ActorSystem = ActorSystem()

  val actor = system.actorOf(Props(new Crawler()))
  implicit val timeout: Timeout = 2.seconds
  actor ! Start
}

object web {
  type Host = String

  case class Url(host: Host, path: String)

  trait Http[F[_]] {
    def get(url: Url): F[String]
  }

  type LinkParser = String => List[Url]

  sealed trait CrawlerMessage

  case class Start(url: Url) extends CrawlerMessage

  case class CrawlResult(url: Url, links: List[Url]) extends CrawlerMessage

  sealed trait WorkerMessage

  case class Crawl(url: Url) extends WorkerMessage

  case class HttpGetResult(url: Url, result: Try[String]) extends WorkerMessage

}

class Crawler(
               http: Http[Future],
               parseLinks: String => List[Url],
               result: Promise[Map[Host, Int]]
             ) extends Actor {

  var referenceCount: Map[Host, Int] = Map[Host, Int]()

  var visitedLinks: Set[Url] = Set[Url]()

  var inProgress: Set[Url] = Set[Url]()

  var workers: Map[Host, ActorRef] = Map[Host, ActorRef]()

  private def crawlUrl(url: Url): Unit = {
    if (!visitedLinks.contains(url)) {
      visitedLinks += url
      inProgress += url
      actorFor(url.host) ! Crawl(url)
    }
  }

  private def actorFor(host: web.Host): ActorRef = {
    workers.get(host) match {
      case None =>
        val workerActor = context.actorOf(Props(new Worker(http, parseLinks, self)))
        workers += host -> workerActor
        workerActor
      case Some(ar) => ar
    }
  }

  override def receive: Receive = {
    case Start(start) => crawlUrl(start)
    case CrawlResult(url, links) =>
      inProgress -= url
      links.foreach { link =>
        crawlUrl(link)
        referenceCount = referenceCount.updated(link.host, referenceCount.getOrElse(link.host, 0) + 1)
      }
      if (inProgress.isEmpty) {
        result.success(referenceCount)
        context.stop(self)
      }
  }
}


class Worker(http: Http[Future],
             parseLinks: String => List[Url],
             master: ActorRef) extends Actor with ActorLogging {
  var urlsPending: Vector[Url] = Vector.empty

  var getInProgress = false

  override def receive: Receive = {

    case Crawl(url) =>
      urlsPending = urlsPending :+ url
      startHttpGetIfPossible()

    case HttpGetResult(url, Success(body)) =>
      getInProgress = false
      startHttpGetIfPossible()
      val links = parseLinks(body)
      master ! CrawlResult(url, links)

    case HttpGetResult(url, Failure(exception)) =>
      getInProgress = false
      startHttpGetIfPossible()
      log.error(s"Cannot get content of $url", exception)
      master ! CrawlResult(url, Nil)
  }

  def startHttpGetIfPossible(): Unit = {
    urlsPending match {
      case url +: tail if !getInProgress =>
        getInProgress = true
        urlsPending = tail
        import context.dispatcher
        http.get(url).onComplete(r => self ! HttpGetResult(url, r))
    }
  }
}