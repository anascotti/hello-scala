ThisBuild / scalaVersion := "2.12.10"
ThisBuild / organization := "com.awesome"

lazy val http4sVersion = "0.21.0-M4"
lazy val circeVersion = "0.12.1"
lazy val catsVersion = "2.0.0"
lazy val scalaticVersion = "3.1.0-RC2"
lazy val doobieVersion = "0.8.0-M2"
lazy val akkaVersion = "2.6.0-RC1"

lazy val hello = (project in file ("."))
  .aggregate(helloTypelevel)
  .settings(
    name := "hello-scala"
  )

lazy val helloTypelevel = (project in file ("hello-typelevel"))
  .settings(
    name := "hello-typelevel",
    libraryDependencies ++= Seq(

      "org.scalactic" %% "scalactic" % scalaticVersion,
      "org.scalatest" %% "scalatest" % scalaticVersion % Test,

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


lazy val helloAkka = (project in file ("hello-akka"))
  .settings(
    name := "hello-akka",

    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
      "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion % Test,
      "org.scalatest" %% "scalatest" % "3.0.8" % Test,
      "ch.qos.logback" % "logback-classic" % "1.1.3" % Runtime

    )

  )
