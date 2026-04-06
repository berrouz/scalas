import scala.language.postfixOps
import kotlin.Keys._

name := "scalas"

version := "0.1"

scalaVersion := "2.13.10"

lazy val coding = project
  .enablePlugins(KotlinPlugin)
  .settings(
    kotlinVersion := "1.9.22",
    kotlincJvmTarget := "17",
    libraryDependencies ++= dependencies,
    kotlinLib("stdlib")
  )

lazy val kotlinModule = project.in(file("kotlin"))
  .enablePlugins(KotlinPlugin)
  .settings(
    kotlinVersion := "1.9.22",
    kotlincJvmTarget := "17",
    kotlinLib("stdlib"),
    kotlinLib("reflect"),
    libraryDependencies ++= kotlinDependencies
  )

lazy val root = Project(id = "scalas", base = file(".")).aggregate(coding, kotlinModule)

val CirceVersion = "0.13.0"
val ShapelessVersion = "2.3.3"
val CatsEffectVersion = "2.1.3"
val cats = "org.typelevel" %% "cats-core" % "2.1.0"

val circeExtras = "io.circe" %% "circe-generic-extras" % CirceVersion
val circeParser = "io.circe" %% "circe-parser" % CirceVersion
val circeLiteral = "io.circe" %% "circe-literal" % CirceVersion

val shapeless = "com.chuusai" %% "shapeless" % ShapelessVersion
val catsEffect = "org.typelevel" %% "cats-effect" % CatsEffectVersion

val zio = "dev.zio" %% "zio" % Versions.zio
val zioTest = "dev.zio" %% "zio-test" % Versions.zio % "test"
val zioTestSbt = "dev.zio" %% "zio-test-sbt" % Versions.zio % "test"
val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest % Test
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
val zioLogging = "dev.zio" %% "zio-logging" % "0.5.14"
val zioTestMain = "dev.zio" %% "zio-test" % Versions.zio

val enumeratum          = "com.beachape" %% "enumeratum" % Versions.enumeratum
val `enumeratum-doobie` = "com.beachape" %% "enumeratum-doobie" % Versions.enumeratumDoobie
val `enumeratum-circe`  = "com.beachape" %% "enumeratum-circe" % Versions.enumeratumCirce
val zioStreams        = "dev.zio" %% "zio-streams"         % Versions.zioStreams
val zioKafka          = "dev.zio" %% "zio-kafka"           % Versions.zioKafka


val magnolia = "com.softwaremill.magnolia1_2" %% "magnolia" % "1.1.3"


lazy val dependencies: Seq[ModuleID] = Seq(
  cats,
  circeExtras,
  //circeGenericApplicative,
  circeParser,
  circeLiteral,
  shapeless,
  catsEffect,
  zio,
  zioTest,
  zioTestSbt,
  scalaTest,
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
  zioLogging,
  zioTestMain,
  magnolia
)


lazy val kotlinDependencies: Seq[ModuleID] = Seq(
  // Coroutines
  "org.jetbrains.kotlinx" % "kotlinx-coroutines-core" % "1.7.3",
  "org.jetbrains.kotlinx" % "kotlinx-coroutines-test" % "1.7.3" % Test,
  // Serialization
  "org.jetbrains.kotlinx" % "kotlinx-serialization-json-jvm" % "1.6.2",
  // Arrow
  "io.arrow-kt" % "arrow-core-jvm" % "1.2.1",
  "io.arrow-kt" % "arrow-fx-coroutines-jvm" % "1.2.1",
  // Ktor
  "io.ktor" % "ktor-server-core-jvm" % "2.3.7",
  "io.ktor" % "ktor-server-netty-jvm" % "2.3.7",
  "io.ktor" % "ktor-client-core-jvm" % "2.3.7",
  "io.ktor" % "ktor-client-cio-jvm" % "2.3.7",
  // Exposed
  "org.jetbrains.exposed" % "exposed-core" % "0.45.0",
  "org.jetbrains.exposed" % "exposed-dao" % "0.45.0",
  "org.jetbrains.exposed" % "exposed-jdbc" % "0.45.0",
  // gRPC
  "io.grpc" % "grpc-kotlin-stub" % "1.4.1",
  "io.grpc" % "grpc-protobuf" % "1.60.0",
  "io.grpc" % "grpc-netty-shaded" % "1.60.0",
  // Kafka
  "org.apache.kafka" % "kafka-clients" % "3.6.1",
  // Database
  "com.h2database" % "h2" % "2.2.224" % Test
)

