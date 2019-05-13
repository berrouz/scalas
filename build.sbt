import scala.language.postfixOps

name := "scalas"

version := "0.1"

scalaVersion := "2.12.8"

lazy val coding = project

lazy val root = Project(id = "scalas", base = file(".")).aggregate(coding)
