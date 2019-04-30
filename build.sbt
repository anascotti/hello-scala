ThisBuild / scalaVersion := "2.12.7"
ThisBuild / organization := "com.awesome"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
val http4sVersion = "0.20.0-M7"
val circecVersion = "0.10.0"

lazy val hello = (project in file ("."))
  .aggregate(helloTypelevel)
  .settings(
    name := "hello-scala-playground"
  )

lazy val helloTypelevel = (project in file ("hello-typelevel"))
  .settings(
    name := "hello-typelevel",
    libraryDependencies ++= Seq(

      "org.scalactic" %% "scalactic" % "3.0.5",
      "org.scalatest" %% "scalatest" % "3.0.5" % "test",

      "org.http4s" %% "http4s-dsl" % http4sVersion,
      "org.http4s" %% "http4s-blaze-server" % http4sVersion,
      "org.http4s" %% "http4s-blaze-client" % http4sVersion,
      "org.http4s" %% "http4s-circe" % http4sVersion,

      "io.circe" %% "circe-core" % circecVersion,
      "io.circe" %% "circe-generic" % circecVersion,

      "joda-time" % "joda-time" % "2.10.1",

      "org.typelevel" %% "cats-core" % "1.4.0",
      "org.typelevel" %% "cats-effect" % "1.0.0",

      "org.tpolecat" %% "doobie-core" % "0.6.0",
      "org.tpolecat" %% "doobie-h2" % "0.6.0",
      "org.tpolecat" %% "doobie-hikari" % "0.6.0",

      "org.scalamock" %% "scalamock" % "4.1.0" % Test
    ),
  )
