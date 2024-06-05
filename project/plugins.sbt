addSbtPlugin("com.typesafe.play" % "sbt-plugin"    % "2.6.24")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")
ThisBuild / libraryDependencySchemes ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always
)