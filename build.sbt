import scala.language.postfixOps

name := "scalas"

version := "0.1"

scalaVersion := "2.12.8"

lazy val coding = project.settings(libraryDependencies ++= dependencies)


lazy val root = Project(id = "scalas", base = file(".")).aggregate(coding)

val CirceVersion = "0.13.0"
val ShapelessVersion = "2.3.3"
val CatsEffectVersion = "2.1.3"
val cats = "org.typelevel" %% "cats-core" % "2.1.0"
val circeExtras  = "io.circe" %% "circe-generic-extras" % CirceVersion
val circeGeneric = "io.circe" %% "circe-generic" %  CirceVersion
val circeParser  = "io.circe" %% "circe-parser" % CirceVersion
val circeLiteral = "io.circe" %% "circe-literal" % CirceVersion
val shapeless             = "com.chuusai" %% "shapeless" % ShapelessVersion
val catsEffect = "org.typelevel" %% "cats-effect" % CatsEffectVersion
lazy val dependencies: Seq[ModuleID] = Seq(
  cats,
  circeExtras,
  circeGeneric,
  circeParser,
  circeLiteral,
  shapeless,
  catsEffect
)