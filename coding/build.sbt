import scala.language.postfixOps

name := "coding"

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "3.0.6",
    "com.typesafe.akka" %% "akka-actor" % "2.5.22",
    "com.chuusai" %% "shapeless" % "2.3.3")
}
