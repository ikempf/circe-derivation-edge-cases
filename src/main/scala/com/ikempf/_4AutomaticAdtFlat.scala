package com.ikempf

import cats.Show
import io.circe.ObjectEncoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._

object _4AutomaticAdtFlat extends App {

  sealed trait Parent1
  case class Child1(a: String, b: String) extends Parent1
  case class Child2(a: String, b: String) extends Parent1
  case class Child3(c: String, d: String) extends Parent1
  implicit val showP1: Show[Parent1] = Show.fromToString[Parent1]
  implicit val showC1: Show[Child1]  = Show.fromToString[Child1]
  implicit val showC2: Show[Child2]  = Show.fromToString[Child2]
  implicit val showC3: Show[Child3]  = Show.fromToString[Child3]

  implicit val genDevConfig: Configuration = Configuration.default.withDiscriminator("type")

  val input       = Child1("a", "b")
  val jsonObject1 = ObjectEncoder[Parent1].apply(input)
  val jsonObject2 = ObjectEncoder[Child1].apply(input)

  println(jsonObject1)
  println(jsonObject2)

}
