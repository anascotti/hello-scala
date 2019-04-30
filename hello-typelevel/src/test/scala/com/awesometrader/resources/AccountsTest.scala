package com.awesometrader.resources

import java.util.UUID

import cats.effect.IO
import com.awesometrader.db.AccountRepository
import com.awesometrader.domain._
import io.circe.Json
import org.http4s.{Method, Request, Response, Status}
import org.scalatest._
import org.http4s.circe._
import org.http4s.implicits._
import org.scalamock.scalatest.MockFactory

class AccountsTest extends FlatSpec with MockFactory with Matchers {

  private val repository = stub[AccountRepository[IO]]

  "POST /accounts" should "return 201 on valid request body" in {
    val requestBody = Json.obj(
      ("ssn", Json.fromString("199001014444")),
      ("email", Json.fromString("miew@cats.com")),
      ("currency", Json.fromString("SEK")),
    )
    val account = Account.create(AccountId(UUID.randomUUID()), Ssn("123455661234"), Email("a@b.com"), SEK)
    (repository.save _) when(*) returns(IO.pure(account))

    val service: IO[Response[IO]] =
      (new Accounts[IO](repository).routes._2).orNotFound
        .run(Request(method = Method.POST).withEntity(requestBody))

    val response = service.unsafeRunSync()

    response.status shouldBe Status.Created
    println(response.headers)

  }
  it should "return location header for created resource" in pending

  "GET /accounts/{id}" should "return 200 for a valid account" in pending
  it should "return 404 if the account does not exist" in pending
  it should "be safe" in pending

  "POST /accounts/{id}/deposit" should "return 200 for deposit transaction accepted" in pending
  it should "return 204 if deposit is made with inexistent account" in pending

}
