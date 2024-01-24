import scala.language.postfixOps
import play.sbt.routes.RoutesKeys

name := "scalas"

version := "0.1"

scalaVersion := "2.13.10"

lazy val coding = project.settings(libraryDependencies ++= dependencies)
lazy val avro4s = project.settings(libraryDependencies ++= avroDeps)
lazy val magnoliaKafka = project.settings(libraryDependencies ++= magnoliaDeps)
lazy val player = project.settings(libraryDependencies ++= playDeps).enablePlugins(PlayScala)
lazy val zio = project.settings(libraryDependencies ++= zioDeps).enablePlugins(PlayScala)

lazy val root = Project(id = "scalas", base = file("."))
  .aggregate(coding, player, zio)

val CirceVersion = "0.13.0"
val ShapelessVersion = "2.3.3"
val CatsEffectVersion = "2.1.3"
val cats = "org.typelevel" %% "cats-core" % "2.1.0"

val avro = "com.sksamuel.avro4s" %% "avro4s-core" % "4.1.0"
val circeExtras = "io.circe" %% "circe-generic-extras" % CirceVersion
val circeGeneric = "io.circe" %% "circe-generic" % CirceVersion
val circeParser = "io.circe" %% "circe-parser" % CirceVersion
val circeLiteral = "io.circe" %% "circe-literal" % CirceVersion

val shapeless = "com.chuusai" %% "shapeless" % ShapelessVersion
val catsEffect = "org.typelevel" %% "cats-effect" % CatsEffectVersion

val zioDev = "dev.zio" %% "zio" % Versions.zio
val zioTest = "dev.zio" %% "zio-test" % Versions.zio % "test"
val zioTestSbt = "dev.zio" %% "zio-test-sbt" % Versions.zio % "test"
val `zioInteropCats` = "dev.zio" %% "zio-interop-cats" % Versions.zioInteropCats
val zioMacros = "dev.zio" %% "zio-macros" % Versions.zio
val refined = "eu.timepit" %% "refined" % Versions.refined
val zioConfig = "dev.zio" %% "zio-config" % Versions.zioConfig

val zioConfigMagnolia = "dev.zio" %% "zio-config-magnolia" % Versions.zioConfig
val zioConfigTypesafe = "dev.zio" %% "zio-config-typesafe" % Versions.zioConfig
val zioConfigRefined = "dev.zio" %% "zio-config-refined" % Versions.zioConfig
val zioConfigYaml = "dev.zio" %% "zio-config-yaml" % Versions.zioConfig
val zioConfigGen = "dev.zio" %% "zio-config-gen" % Versions.zioConfig
val zioJson = "dev.zio" %% "zio-json" % Versions.zioJson

val enumeratum          = "com.beachape" %% "enumeratum" % Versions.enumeratum
val `enumeratum-doobie` = "com.beachape" %% "enumeratum-doobie" % Versions.enumeratumDoobie
val `enumeratum-circe`  = "com.beachape" %% "enumeratum-circe" % Versions.enumeratumCirce
val zioStreams        = "dev.zio" %% "zio-streams"         % Versions.zioStreams
val zioKafka          = "dev.zio" %% "zio-kafka"           % Versions.zioKafka

val playSlick = "com.typesafe.play" %% "play-slick" % "3.0.4"
val playSlickEvo = "com.typesafe.play" %% "play-slick-evolutions" % "3.0.4"
val slick             = "com.typesafe.slick"    %% "slick"  % "3.2.3"
val postgresql           = "org.postgresql"      % "postgresql"              % "42.2.8"
val playJson          = "com.typesafe.play"     %% "play-json"             % "2.6.14"

val magnolia = "com.softwaremill.magnolia1_2" %% "magnolia" % "1.1.3"
val sttp = "com.softwaremill.sttp.client3" %% "core" % "3.5.2"
val httpClient = "com.softwaremill.sttp.client3" %% "httpclient-backend" % "3.5.2"

lazy val playDeps: Seq[ModuleID] = Seq(
  playSlick, playSlickEvo, slick, postgresql, playJson
)

lazy val avroDeps: Seq[ModuleID] = Seq(
  avro
)

lazy val zioDeps: Seq[ModuleID] = Seq(
  zioDev,
  zioTest,
  zioTestSbt,
  zioMacros,
  `zioInteropCats`,
  zioConfig,
  zioConfigMagnolia,
  zioConfigTypesafe,
  zioConfigRefined,
  zioConfigYaml,
  zioConfigGen,
)

lazy val magnoliaDeps: Seq[ModuleID] = Seq(
  avro, magnolia
)

lazy val dependencies: Seq[ModuleID] = Seq(
  cats,
  circeExtras,
  circeGeneric,
  circeParser,
  circeLiteral,
  shapeless,
  catsEffect,
  zioDev,
  zioTest,
  zioTestSbt,
  zioMacros,
  `zioInteropCats`,
  zioConfig,
  zioConfigMagnolia,
  zioConfigTypesafe,
  zioConfigRefined,
  zioConfigYaml,
  zioConfigGen,
  refined,
  `enumeratum-circe`,
  enumeratum,
  `enumeratum-doobie`,
  zioStreams,
  zioKafka,
  zioJson,
  magnolia,
  sttp,
  httpClient
)


import play.sbt.routes.RoutesKeys
RoutesKeys.routesImport := Seq.empty
