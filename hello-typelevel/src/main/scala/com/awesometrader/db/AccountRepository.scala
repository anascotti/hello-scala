package com.awesometrader.db

import cats.effect.Sync
import com.awesometrader.domain.Account
import doobie.util.transactor.Transactor

class AccountRepository[F[_]: Sync](xa: Transactor[F]) {

  def save(account: Account): F[Account] = ???
}

object AccountRepository {
  def apply[F[_]: Sync](xa: Transactor[F]): AccountRepository[F] = new AccountRepository[F](xa)
}
