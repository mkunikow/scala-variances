package com.jayway

/**
 * Created by michal on 12/18/14.
 * Based on [[http://www.jayway.com/2011/10/04/scala-type-variances-part-two// Scala Type Variances Part Two]]
 */
object part2 extends App {
//  Contravariant Subtyping
  {
    trait NetworkChannel[-T] {
      def write(x: T)
    }

    class AnyRefChannel extends NetworkChannel[AnyRef] {
      override def write(x:AnyRef) {

      }
    }

    class StringChannel extends NetworkChannel[String] {
      override def write(x:String) {

      }
    }

    class BufferControl {
      def control(channel:NetworkChannel[String]) {

      }
    }

    val ac = new AnyRefChannel()
    val sc = new StringChannel()
    val bc = new BufferControl()

    bc.control(ac)
  }

//  Liskov Substitution Principle (LSP)
//  LSP is a principle in object-oriented programming. It states:
//    It is safe to assume that S is a subtype of T if you can substitute a value of type S
//    wherever a value of type T is required without violating the desirable properties of the program [2].

}
