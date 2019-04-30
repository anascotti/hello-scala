package com.awesometrader.resources

import org.scalatest._

class PortfolioTest extends FlatSpec with Matchers {

  "GET /account/{id}/orders" should "return 200 for a valid account" in pending
  it should "return 404 if account is inexistent" in pending
  it should "return all orders placed for a valid account with links to orders" in pending
  it should "be safe"

  "GET /account/{id}/portfolio" should "return 200 for a valid account" in pending
  it should "return 404 if account does not exits" in pending
  it should "return all assets for the given account" in pending
  it should "be safe"
}
