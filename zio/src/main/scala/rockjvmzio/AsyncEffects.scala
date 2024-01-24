package rockjvmzio

import rockjvmzio.AsyncEffects.LoginService.{AuthError, UserProfile}
import zio.{Scope, Task, ZIO, ZIOAppArgs, ZIOAppDefault}

import java.util.concurrent.{ExecutorService, Executors}
import scala.util.{Failure, Success, Try}

object AsyncEffects extends ZIOAppDefault {


  object LoginService {

    case class AuthError(message: String)

    case class UserProfile(message: String, name: String)
  }

  val executor = Executors.newFixedThreadPool(8)

  val passwd = Map("serhii@gmail.com" -> "Rock")


  val database = Map(
    "serhii" -> "Serhii"
  )

  def login(email: String, password: String)(onSuccess: UserProfile => Unit, onFailure: AuthError => Unit): Unit = {
    executor.execute { () =>
      println(Thread.currentThread().getName)
      passwd.get(email) match {
        case Some(password) => onSuccess(UserProfile(email, database(email)))
        case Some(_) => onFailure(AuthError("incorrect password"))
        case None => onFailure(AuthError("User doesn't exist. Please sign up."))
      }

    }
  }

  def loginAsZio(id: String, password: String): ZIO[Any, LoginService.AuthError, LoginService.UserProfile] = {
    ZIO.async { cb =>
      login(email = id, password = password)(profile => cb(ZIO.succeed(profile)), error => cb(ZIO.fail(error)))
    }
  }

  // 1

  def external2Zio[A](computation: () => A)(executor: ExecutorService): Task[A] = {
      ZIO.async { cb =>
        executor.execute {() =>
          println(Thread.currentThread().getName)
          Try {
            computation()
          } match {
            case Success(value) => //cb(ZIO.succeed(value))
            case Failure(exc) => cb(ZIO.fail(exc))
          }
        }
    }
  }


  override def run: ZIO[Any with ZIOAppArgs with Scope, Any, Any] = {
    //loginAsZio("root", "1234REwq")

    external2Zio(() => println("Completed"))(Executors.newCachedThreadPool())
  }

}
