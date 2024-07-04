package org.shev4ik.rockjvm.data_manipulation

import cats.Id
import cats.data.{Kleisli, Reader}

object Readers extends App {

  /*
  * configuration file => initial data structure
  * a DB layer
  * an HTTP layer
  * a business layer
  */

  case class Config(dbUsername: String, dbPassword: String, host: String, port: Int, nThreads: Int)


  case class DbConnection(username: String, password: String){
    def getOrderStatus(orderId: Long): String = "dispatched"
  }

  case class HttpService(host: String, port: Int){
    def start(): Unit = println("Server started")
  }

  val config = Config("Serhii", "Rocked", "Localhost", 1234, 8)

  val dbReader: Reader[Config, DbConnection] = Reader(config => DbConnection(config.dbUsername, config.dbPassword))

  val dbConnection = dbReader.run(config)

  // Reader[I,O]

  val danielsOrderStatusReader: Reader[Config, String] = dbReader.map(_.getOrderStatus(55))


  case class EmailService(emailReplyTo: String){
    def sendEmail(address: String, contents: String) = s"From: $address; to: $address >>> $contents"
  }

  def emailsUser(username: String, userEmail: String)= {
    dbReader.map(config => config.getOrderStatus(1))
      .map(s => EmailService(s).sendEmail(userEmail, "hello")).run(config)

    // fetch the status of their last order
    // email them with the Email service: "your last order has the status: (status)"
  }
  List(1,2,3).map(identity)
}
