package org.shev4ik.rockjvm.cats.monad

import cats.Monad
import java.util.concurrent.Executors
import scala.collection.immutable
import scala.concurrent.{ExecutionContext, Future}
import scala.language.higherKinds
import scala.util.Try

object MonadApp extends App {

    trait MyFunctor[F[_]] {
      def map[A,B](value: F[A])(f: A => B): F[B]
    }

  import cats.Functor

  import cats.instances.list._
  import cats.instances.option._
  import cats.instances.try_._

  val listFunctor: Functor[List] = Functor[List]
  val incrementedNumbers = listFunctor.map(List(1,2,3))(_ + 23)

  val optionFunctor: Functor[Option] = Functor[Option]
  val incrementedOption = optionFunctor.map(Option(3))(_ + 3)

  val tryFunctor: Functor[Try] = Functor[Try]
  val incrementedTry = tryFunctor.map(Try(3))(_+4)


  trait Tree[+T]
  case class Leaf[+T](value: T) extends Tree[T]
  case class Branch[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

  implicit val f: Functor[Tree] = new Functor[Tree]{
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = fa match {
      case Leaf(value) => Leaf(f(value))
      case Branch(value, left, right) => Branch(f(value), map(left)(f), map(right)(f))
    }
  }

  def do10x[F[_], T](f: F[Int])(implicit functor: Functor[F]): F[Int] = functor.map(f)(_*10)

  val numbersList = List(1,2,3)
  val charsList = List('a','b','c')

  val combinations = for {
    n <- numbersList
    c <- charsList
  } yield (n, c)

  implicit val ec: ExecutionContext =
    ExecutionContext.fromExecutorService(Executors.newFixedThreadPool(8))

  val result = for {
    f1 <- Future(43)
    f2 <- Future('Z')
  } yield (f1, f2)

  println(result.onComplete(r => println(r)))

  Option(10).flatMap(i => Some(4))

  import cats.instances.option._
  val optionMonad: Monad[Option] = Monad[Option]

  val anOption: Option[Int] = optionMonad.pure(4)
    optionMonad.flatMap(anOption)(x => if (x % 3 == 0) Some(x +1) else None)

  import cats.instances.list._
  val listMonad = Monad[List]

  val aList = listMonad.pure(3)

  val aTransformedList: immutable.Seq[Int] = listMonad.flatMap(aList)(x => List(x, x +32))

  import cats.instances.future._
  val futureMonad = Monad[Future]

  val future = futureMonad.pure(10)

  val aTransformedFuture = futureMonad.flatMap(future)(res => Future(res))

  aTransformedFuture.onComplete(s => println(s))

  import cats.syntax.applicative._

  val anOption1 = 1.pure[Option]

  val oneList = 1.pure[List]

  val oneOptionTransformed = anOption1.flatMap(x => (x+1).pure[Option])

  trait MyMonad[M[_]] {
    def pure[A](value: A): M[A]
    def flatMap[A,B](ma: M[A])(f: A => M[B]): M[B]
    def map[A,B](ma: M[A])(f: A => B): M[B] = flatMap(ma)(a => pure(f(a)))
  }


  case class Connection(host: String, port: String)

  val config = Map(
    "host" -> "localhost",
    "port" -> "4040"
  )

  trait HttpService[M[_]] {
    def getConnection(cfg: Map[String, String]): M[Connection]
    def issueRequest(connection: Connection, payload: String): M[String]
  }


  class HttpServiceImpl extends HttpService[Option] {
    override def issueRequest(connection: Connection, payload: String): Option[String] = {
      if (payload.length < 20) {
        Some(payload)
      } else {
        None
      }

    }

    override def getConnection(cfg: Map[String, String]): Option[Connection] = for {
      host <- cfg.get("host")
      port <- cfg.get("port")
    } yield Connection(host, port)
  }

  for {
    connection <- new HttpServiceImpl().getConnection(config)
    result <- new HttpServiceImpl().issueRequest(connection, "result")
  } yield ()
}
