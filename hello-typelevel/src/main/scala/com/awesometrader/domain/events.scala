package com.awesometrader.domain

final case class AccountCreated(id: AccountId)

final case class DepositRequested(id: AccountId)
final case class DepositConfirmed(id: AccountId)
final case class DepositFailed(id: AccountId)

final case class OrderPlaced(id: AccountId)
final case class OrderApproved(id: AccountId)
final case class OrderCompleted(id: AccountId)
final case class OrderRejected(id: AccountId)
final case class OrderExpired(id: AccountId)
final case class OrderCancelled(id: AccountId)
