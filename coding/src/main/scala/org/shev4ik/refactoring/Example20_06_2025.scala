package org.shev4ik.refactoring

object Example20_06_2025 extends App {

  case class User(name: String, age: Int, email: String)

  object UserProcessor {
    def process(users: List[User]): Unit = {
      val result: Seq[String] = users.flatMap(user => {
        Seq(checkAge(user), sendEmail(user))
      })
      result.foreach(println)
    }

    private def checkAge(user: User): String = {
      user.age match {
        case age if age > 65 => user.name + " is a senior"
        case age if age > 18 => user.name + " is adult"
        case _ => user.name + " is minor"
      }
    }

    private def sendEmail(user: User): String = {
      if (user.email.contains("@")) {
        "Sending email to " + user.email
      } else {
        "Invalid email: " + user.email
      }
    }
  }
}
