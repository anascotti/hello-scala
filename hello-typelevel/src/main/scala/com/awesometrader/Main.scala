package com.awesometrader

import cats.implicits._
import cats.effect.{ContextShift, ExitCode, IO, IOApp}
import db.{AccountRepository, AwesomeDatabase}
import org.http4s.implicits._
import org.http4s.server.Router
import org.http4s.server.blaze.BlazeServerBuilder
import resources.{Accounts, Orders}

import scala.concurrent.ExecutionContext.Implicits.global

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] =
    for {
      tx <- AwesomeDatabase.transactor
      accountsResource = Accounts[IO](AccountRepository(tx)).routes
      ordersResource = Orders[IO].routes
      routes = Router(accountsResource, ordersResource).orNotFound
      exitCode <- BlazeServerBuilder[IO]
        .bindHttp(8080, "localhost")
        .withHttpApp(routes)
        .serve
        .compile
        .drain
        .as(ExitCode.Success)
    } yield exitCode


  implicit val cs: ContextShift[IO] = IO.contextShift(global)

}
