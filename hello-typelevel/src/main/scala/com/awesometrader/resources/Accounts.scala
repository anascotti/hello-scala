package com.awesometrader.resources

import io.circe.generic.auto._
import cats.implicits._
import cats.effect.Sync
import com.awesometrader.api.CreateAccount
import com.awesometrader.db.AccountRepository
import com.awesometrader.domain._
import org.http4s.{HttpRoutes, Uri}
import org.http4s.dsl.Http4sDsl
import org.http4s.circe._
import org.http4s.headers.Location

class Accounts[F[_]: Sync](repository: AccountRepository[F]) extends Http4sDsl[F] {

  private val rootPath = "/accounts"

  val routes: (String, HttpRoutes[F]) = (rootPath, HttpRoutes.of[F] {
    case req @ POST -> Root =>
      req.decodeJson[CreateAccount].flatMap(create(_))
    case GET -> Root / id                    => ??? // show account
    case req @ POST -> Root / id / "deposit" => ??? // deposit into account

  })

  def create(req: CreateAccount) =
    for {
      uuid <- AccountId.randomUUID[F]
      acc = Account.create(AccountId(uuid), Ssn(req.ssn), Email(req.email), SEK)
      _ <- repository.save(acc)
      resp <- Created(Location(Uri(path = s"$rootPath/${uuid.toString}")))
    } yield resp
}

object Accounts {
  def apply[F[_]: Sync](repository: AccountRepository[F]): Accounts[F] = new Accounts[F](repository)
}
