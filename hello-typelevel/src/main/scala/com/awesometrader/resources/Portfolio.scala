package com.awesometrader.resources

import cats.effect.Sync
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

class Portfolio[F[_]: Sync] extends Http4sDsl[F] {

  private val rootPath = "/accounts"

  val routes: (String, HttpRoutes[F]) = (rootPath, HttpRoutes.of[F] {
    case GET -> Root / id / "orders"    => ??? // show all orders for account
    case GET -> Root / id / "portfolio" => ??? // show the portfolio
  })
}

object Portfolio {
  def apply[F[_]: Sync](): Portfolio[F] = new Portfolio[F]
}
