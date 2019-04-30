package com.awesometrader.resources

import org.scalatest._

class OrdersTest extends FlatSpec with Matchers {

  "POST to /orders" should "return 201 on order placed" in pending

  "DELETE /orders/{id}" should "return 200 if the order is cancellable" in pending
  it should "return 204 on for inexistent order" in pending
  it should "be idempotent" in pending
}
