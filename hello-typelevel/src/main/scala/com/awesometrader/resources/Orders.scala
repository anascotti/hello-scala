package com.awesometrader.resources

import cats.effect.Sync
import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl

class Orders[F[_]: Sync] extends Http4sDsl[F] {

  private val rootPath = "/orders"

  val routes: (String, HttpRoutes[F]) = (rootPath, HttpRoutes.of[F] {
    case req @ POST -> Root  => ??? // place an order
    case GET -> Root / id    => ??? // show an order
    case DELETE -> Root / id => ??? // cancel an order

  })
}

object Orders {
  def apply[F[_]: Sync](): Orders[F] = new Orders[F]
}
