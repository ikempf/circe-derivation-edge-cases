package com

import cats.Show
import cats.implicits._
import io.circe.Decoder.Result

package object ikempf {

  def test[A: Show](a: A, b: Result[A]): Unit =
    b.fold(
      failure => println(show"KO: $a != $b, ${failure.getMessage()}"),
      bb => test(a, bb)
    )

  def test[A: Show](a: A, b: A): Unit =
    if (a == b)
      println(show"OK: $a == $b")
    else
      println(show"KO: $a != $b")

}
