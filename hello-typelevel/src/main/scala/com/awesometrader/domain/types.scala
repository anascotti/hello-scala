package com.awesometrader.domain

import java.util.UUID

import cats.effect.Sync
import org.joda.time.DateTime

final case class AccountId(uuid: UUID) extends AnyVal

object AccountId {
  def apply(id: UUID): AccountId = new AccountId(id)
  def randomUUID[F[_]: Sync]: F[UUID] = Sync[F].delay { UUID.randomUUID() }
}

final case class StateTransitionError(msg: String)

sealed trait Currency
case object SEK extends Currency
case object USD extends Currency

final case class Amount(currency: Currency, value: Long)
sealed trait OrderStatus
case object Placed extends OrderStatus
case object Working extends OrderStatus
case object Completed extends OrderStatus
case object Expired extends OrderStatus
case object Cancelled extends OrderStatus
case object Rejected extends OrderStatus

final case class Asset(id: UUID,
                       name: String,
                       currency: Currency,
                       currentValue: Long)

final case class Order(id: UUID,
                       accountId: AccountId,
                       status: OrderStatus,
                       securityId: UUID,
                       quantity: Int,
                       quotation: Long,
                       amount: Amount,
                       expiresOn: DateTime)

final case class Portfolio(accountId: AccountId, assets: List[Asset])
