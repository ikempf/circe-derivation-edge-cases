package com.ikempf

import cats.Show
import io.circe.ObjectEncoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._

object _4AutomaticAdtFlat extends App {

  sealed trait Parent
  case class Child1(a: String, b: String) extends Parent
  case class Child2(a: String, b: String) extends Parent
  case class Child3(c: String, d: String) extends Parent
  implicit val showP1: Show[Parent] = Show.fromToString[Parent]
  implicit val showC1: Show[Child1]  = Show.fromToString[Child1]
  implicit val showC2: Show[Child2]  = Show.fromToString[Child2]
  implicit val showC3: Show[Child3]  = Show.fromToString[Child3]

  implicit val genDevConfig: Configuration = Configuration.default.withDiscriminator("type")

  val input       = Child1("a", "b")
  val jsonObject1 = ObjectEncoder[Parent].apply(input)
  val jsonObject2 = ObjectEncoder[Child1].apply(input)

  import io.circe.syntax._
  input.asJson
  (input: Parent).asJson
  println(jsonObject1) // type
  println(jsonObject2) // no type

}
