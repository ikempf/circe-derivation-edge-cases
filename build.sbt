val circeVersion = "0.10.0"

lazy val `circe-edge-cases` = (project in file("."))
  .settings(
    organization := "com.ikempf",
    name := "circe-edge-cases",
    scalaVersion := "2.12.8",
    scalacOptions += "-Ypartial-unification",
    libraryDependencies ++= List(
      "org.typelevel" %% "cats-core"            % "1.6.0",
      "io.circe"      %% "circe-core"           % circeVersion,
      "io.circe"      %% "circe-parser"         % circeVersion,
      "io.circe"      %% "circe-generic"        % circeVersion,
      "io.circe"      %% "circe-generic-extras" % circeVersion,
      "io.circe"      %% "circe-literal"        % circeVersion,
      "org.scalatest" %% "scalatest"            % "3.0.5" % Test
    ),
    addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.8"),
    scalacOptions ++= List(
      "-target:jvm-1.8",
      "-feature",
      "-encoding",
      "UTF-8",
      "-unchecked",
      "-deprecation",
      "-language:higherKinds",
      "-Xlint",
      "-Ypartial-unification",
      "-Ywarn-dead-code",
      "-Ywarn-infer-any",
      "-Ywarn-nullary-override",
      "-Ywarn-unused:implicits",
      "-Ywarn-unused:imports",
      "-Ywarn-unused:locals",
      "-Ywarn-unused:params",
      "-Ywarn-unused:patvars",
      "-Ywarn-unused:privates",
      "-Ywarn-value-discard"
    ),
  )
