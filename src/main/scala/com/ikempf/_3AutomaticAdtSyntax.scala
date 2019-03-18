package com.ikempf

import cats.Show
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.{Decoder, Json}

object _3AutomaticAdtSyntax extends App {

  sealed trait Parent
  case class Child1(a: String, b: String) extends Parent
  case class Child2(a: String, b: String) extends Parent
  case class Child3(c: String, d: String) extends Parent
  implicit val showP1: Show[Parent] = Show.fromToString[Parent]
  implicit val showC1: Show[Child1] = Show.fromToString[Child1]
  implicit val showC2: Show[Child2] = Show.fromToString[Child2]
  implicit val showC3: Show[Child3] = Show.fromToString[Child3]

  val input         = Child1("a", "b")
  val jsonObject    = input.asJsonObject
  val json          = input.asJson
  val outputObject1 = Decoder[Parent].decodeJson(Json.fromJsonObject(jsonObject))
  val outputObject2 = Decoder[Child1].decodeJson(Json.fromJsonObject(jsonObject))
  val output1       = Decoder[Parent].decodeJson(json)
  val output2       = Decoder[Child1].decodeJson(json)
  test(input, outputObject1) // KO
  test(input, outputObject2) // OK
  test(input, output1)       // KO
  test(input, output2)       // OK

}
