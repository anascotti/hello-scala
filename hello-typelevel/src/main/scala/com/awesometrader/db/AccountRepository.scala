package com.awesometrader.db

import cats.effect.{IO, Sync}
import com.awesometrader.domain.{Account, Created}
import doobie.hikari.HikariTransactor

class AccountRepository[F[_]](transactor: HikariTransactor[IO]) {

  def save(account: Account[Created]): F[Account[Created]] = ???
}

object AccountRepository {
  def apply[F[_]](transactor: HikariTransactor[IO]): AccountRepository[F] = new AccountRepository[F](transactor)
}
