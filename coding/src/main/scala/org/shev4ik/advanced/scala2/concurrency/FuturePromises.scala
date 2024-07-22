package org.shev4ik.advanced.scala2.concurrency

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Random, Success}

object FuturePromises extends App {

  // mini social network

  case class Profile(id: String, name: String) {
    def poke(anotherProfile: Profile): Unit = println(s"${this.name} poking ${anotherProfile.name}")
  }

  object SocialNetwork {
    val names = Map(
      "fb.id.1-zuck" -> "Mark",
      "fb.id.2-bill" -> "Bill",
      "fb.id.3-dummy" -> "Dummy",
    )

    val friends = Map(
      "fb.id.1-zuck" -> "fb.id.2-bill"
    )

    val random = new Random()


    def fetchProfile(id: String): Future[Profile] = Future {
      Thread.sleep(random.nextInt(300))
      Profile(id, names(id))
    }

    def fetchBestFriend(profile: Profile): Future[Profile] = Future {
      Thread.sleep(random.nextInt(400))
      val bfId = friends(profile.id)
      Profile(bfId, names(bfId))
    }

  }

  val mark = SocialNetwork.fetchProfile("fb.id.1-zuck")

  mark.onComplete {
    case Success(markProfile) =>
      val bill = SocialNetwork.fetchBestFriend(markProfile)
      bill.onComplete {
        case Success(billProfile) => markProfile.poke(billProfile)
        case Failure(exception) => exception
      }
  }

  Thread.sleep(1000)

  // functional composition

  val nameOnTheWall = mark.map(profile => profile.name)

  val marksBestFriend = mark.flatMap( profile => SocialNetwork.fetchBestFriend(profile))

  val zuckBestFriendRestricted = marksBestFriend.filter(profile => profile.name.startsWith("Z"))

  val result = for {
    mark <- SocialNetwork.fetchProfile("fb.id.1-zuck")
    bill <- SocialNetwork.fetchBestFriend(mark)
  } yield bill

  result.recover {
    case e: Throwable => Profile("fb.id.0-dummy", "Forever alone")
  }



  /*
  * 1) Fulfill a future Immediately with a value
  * 2) inSequence(fa, fb)
  * 3) first(fa, fb) => new future with the first value of the two futures
  * 4) last(fa, fb) => new future with the last value
  * 5) retryUntil(action: () => Future[T], condition: T => Boolean): Future[T]
  * */



  // 1

  Future.successful(100)

  // 2

  for {
    a <- Future.successful(100)
    b <- Future.successful(100)
  } yield (a + b)

  // 3


  def first[A, B](fa: Future[A], fb: Future[A]): Future[A] = {
    val promise = Promise[A]
    fa.onComplete(promise.tryComplete)
    fb.onComplete(promise.tryComplete)
    promise.future
  }

  Future.traverse()
}
