package com.awesometrader.db

import cats.effect.{IO, Sync}
import doobie.util.transactor.Transactor

object Database {

  def transactor[F[_]: Sync](): Transactor[F] =  ???


}
