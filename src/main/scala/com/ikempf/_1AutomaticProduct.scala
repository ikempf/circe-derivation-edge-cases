package com.ikempf

import cats.Show
import io.circe.generic.auto._
import io.circe.{Decoder, Encoder}

object _1AutomaticProduct extends App {

  case class Basic(a: String, b: String)
  implicit val show: Show[Basic] = Show.fromToString[Basic]

  val input  = Basic("a", "b")
  val json   = Encoder[Basic].apply(input)
  val output = Decoder[Basic].decodeJson(json)
  test(input, output) // OK

}
