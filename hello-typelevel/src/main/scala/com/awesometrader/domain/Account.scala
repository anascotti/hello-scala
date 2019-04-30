package com.awesometrader.domain

final case class Ssn(val id: String) extends AnyVal
final case class Email(val id: String) extends AnyVal

sealed class AccountState
case class Created() extends AccountState
case class Closed() extends AccountState

case class Account[S <: AccountState](val state: S,
                                      val id: AccountId,
                                      val ssn: Ssn,
                                      val email: Email,
                                      val currency: Currency,
                                      val balance: Long)

object Account {

  def create(id: AccountId,
             ssn: Ssn,
             email: Email,
             currency: Currency): Account[Created] =
    new Account(Created(), id, ssn, email, currency, 0)

  def close(in: Account[Created],
            reason: String): Either[StateTransitionError, Account[Closed]] = {
    if (in.balance > 0)
      Left(StateTransitionError("Cannot close account with positive balance"))
    else
      Right(
        new Account(Closed(), in.id, in.ssn, in.email, in.currency, in.balance))
  }
}
