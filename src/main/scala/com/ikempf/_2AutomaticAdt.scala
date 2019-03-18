package com.ikempf

import cats.Show
import io.circe.generic.auto._
import io.circe.{Decoder, Encoder}

object _2AutomaticAdt extends App {

  sealed trait Parent1
  case class Child1(a: String, b: String) extends Parent1
  case class Child2(c: String, d: String) extends Parent1
  implicit val showP1: Show[Parent1] = Show.fromToString[Parent1]
  implicit val showC1: Show[Child1]  = Show.fromToString[Child1]
  implicit val showC2: Show[Child2]  = Show.fromToString[Child2]

  val input = Child1("a", "b")

  val jsonParent = Encoder[Parent1].apply(input)
  val output1    = Decoder[Parent1].decodeJson(jsonParent)
  val output2    = Decoder[Child1].decodeJson(jsonParent)
  test(input, output1) // OK
  test(input, output2) // KO

  val jsonChild = Encoder[Child1].apply(input)
  val output3   = Decoder[Parent1].decodeJson(jsonChild)
  val output4   = Decoder[Child1].decodeJson(jsonChild)
  test(input, output3) // KO
  test(input, output4) // OK

}
