ThisBuild / scalaVersion := "2.13.0"
ThisBuild / organization := "com.awesome"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val http4sVersion = "0.21.0-M4"
val circeVersion = "0.12.1"
val catsVersion = "2.0.0"
val scalaticVersion = "3.1.0-RC2"
val doobieVersion = "0.8.0-M2"

lazy val hello = (project in file ("."))
  .aggregate(helloTypelevel)
  .settings(
    name := "hello-scala-playground"
  )

lazy val helloTypelevel = (project in file ("hello-typelevel"))
  .settings(
    name := "hello-typelevel",
    libraryDependencies ++= Seq(

      "org.scalactic" %% "scalactic" % scalaticVersion,
      "org.scalatest" %% "scalatest" % scalaticVersion % "test",

      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.http4s" %% "http4s-blaze-server" % http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % http4sVersion,
      "org.http4s" %% "http4s-circe" % http4sVersion,

      "io.circe" %% "circe-core" % circeVersion,
      "io.circe" %% "circe-generic" % circeVersion,

      "joda-time" % "joda-time" % "2.10.1",

      "org.typelevel" %% "cats-core" % catsVersion,
      "org.typelevel" %% "cats-effect" % catsVersion,

      "org.tpolecat" %% "doobie-core" % doobieVersion,
      "org.tpolecat" %% "doobie-h2" % doobieVersion,
      "org.tpolecat" %% "doobie-hikari" % doobieVersion,

      "org.scalamock" %% "scalamock" % "4.4.0" % Test
    ),
  )
