package com.jayway

/**
 * Created by michal on 12/18/14.
 * Based on [[http://www.jayway.com/2011/10/04/scala-type-variances-part-three// Scala Type Variances Part Three]]
 */
object part3 extends App {

//  Lower bounds
//  Lower type bounds: help you to declare a type to be a supertype of another type.
// T >: A indicates that type T or abstract type T refers to a supertype of type A.


  {
//    class Company[+T](val company:T) {
//      def partnerWith(y: T) {
//
//      }
//    }
//    won't compile
//    Error: covariant type T occurs in contravariant position in type T of value y

//    scala funtion defintion
//    trait Function1[-S, +T] {
//      def apply(x:S): T
//    }

    //this works
    class Company[+T](val company:T) {
      def partnerWith[U >: T](y: U) {

      }
    }
    //    By this new definition, partnerWith method accepts arguments that can be supertype of type T.

    class BigCompany
    class SmallCompany extends BigCompany

    val littleCompany: Company[SmallCompany] = new Company[SmallCompany](new SmallCompany)
    val bigCompany: Company[BigCompany] = new Company[BigCompany](new BigCompany)
  }

//  Upper bounds
  {
    class BigCompany
    class SmallCompany extends BigCompany

    class Company[+T](val company:T) {
      def partnerWith[U <: Company[BigCompany]](y: U) {

      }
    }
    class CrappyCompany

    val littleCompany: Company[SmallCompany] = new Company[SmallCompany](new SmallCompany)
    val bigCompany: Company[BigCompany] = new Company[BigCompany](new BigCompany)

    littleCompany.partnerWith(bigCompany)


//  This class does not extend BigCompany so Company[CrappyCompany] is not a subtype of Company[BigCompany]
    val crappyCompany: Company[CrappyCompany] = new Company[CrappyCompany](new CrappyCompany)

//    won't compile
//    littleCompany.partnerWith(crappyCompany)
    //error: inferred type arguments [Company[CrappyCompany]] do not conform to method
    //partnerWith's type parameter bounds [U &lt;: Company[BigCompany]]



//    Remember that by definition a class is supertype and subtype of itself.
//    Hence you can pass an instance of Company[BigCompany] to partnerWith:

    val bigCompany2 : Company[BigCompany] = new Company[BigCompany](new BigCompany)
    bigCompany.partnerWith(bigCompany2)
  }

}
