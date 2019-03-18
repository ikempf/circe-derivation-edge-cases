package com.ikempf

import io.circe.Encoder
import io.circe.generic.extras.Configuration
import io.circe.generic.extras.auto._

object _5AutomaticComplexAdt extends App {

  sealed trait Parent
  case class Child1(a: String, b: String) extends Parent
  case class Child2(a: String, b: String) extends Parent
  sealed trait SubParent1                 extends Parent
  case class SubChild(a: String)          extends SubParent1
  sealed trait SubParent2                 extends Parent
  case object SubChild1                   extends SubParent2
  case object SubChild2                   extends SubParent2
  sealed trait SubSubParent               extends SubParent1
  case class SubSubChild1(a: String)      extends SubSubParent

  implicit val genDevConfig: Configuration = Configuration.default.withDiscriminator("type")

  val subsub = SubSubChild1("test")

  println(Encoder[SubSubChild1].apply(subsub)) // no type
  println(Encoder[SubSubParent].apply(subsub)) // type
  println(Encoder[SubParent1].apply(subsub))  // type
  println(Encoder[Parent].apply(subsub))  // type

  println()
  val sub = SubChild1
  println(Encoder[SubChild1.type].apply(sub)) // Empty
  println(Encoder[SubParent2].apply(sub)) // type
  println(Encoder[Parent].apply(sub)) // type

}
