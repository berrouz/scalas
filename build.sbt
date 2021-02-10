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
val circeExtras = "io.circe" %% "circe-generic-extras" % CirceVersion
val circeGeneric = "io.circe" %% "circe-generic" % CirceVersion
val circeParser = "io.circe" %% "circe-parser" % CirceVersion
val circeLiteral = "io.circe" %% "circe-literal" % CirceVersion

val shapeless = "com.chuusai" %% "shapeless" % ShapelessVersion
val catsEffect = "org.typelevel" %% "cats-effect" % CatsEffectVersion

val zio = "dev.zio" %% "zio" % Versions.zio
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

lazy val dependencies: Seq[ModuleID] = Seq(
  cats,
  circeExtras,
  circeGeneric,
  circeParser,
  circeLiteral,
  shapeless,
  catsEffect,
  zio,
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
  refined
)


