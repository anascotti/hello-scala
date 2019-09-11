package com.awesometrader

import cats.effect._
import cats.implicits._
import com.awesometrader.db.{AccountRepository, Database}
import com.awesometrader.resources.Accounts
import org.http4s.implicits._
import fs2.Stream
import org.http4s.server.Router
import org.http4s.server.blaze.BlazeServerBuilder

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] =
    stream[IO].compile.drain.as(ExitCode.Success)

  def stream[F[_]: ConcurrentEffect: ContextShift: Timer]: Stream[F, ExitCode] =
    for {
        xa <- Stream.eval(Database.transactor().pure[F])
        ordersResource = Accounts[F](AccountRepository(xa))
        routes = Router(ordersResource.routes).orNotFound
        exitCode <- BlazeServerBuilder[F]
          .bindHttp(8080, "localhost")
          .withHttpApp(routes)
          .serve
      } yield exitCode

}
