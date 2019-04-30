package com.awesometrader.db

import cats.effect.IO
import doobie.hikari.HikariTransactor

object AwesomeDatabase {

  def transactor: IO[HikariTransactor[IO]] = ???

}
