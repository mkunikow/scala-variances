package com.jayway

/**
 * Created by michal on 12/18/14.
 * Based on [[http://www.jayway.com/2011/10/03/scala-type-variances-part-one/ Scala Type Variances Part One]]
 */
object part1 extends App {
//  Covariant Subtyping
  {
    class Company[T](val company: T)
    class BigCompany
    class SmallCompany extends BigCompany
    class Investor(val company: Company[BigCompany])

    val littleCompany: Company[SmallCompany] = new Company[SmallCompany](new SmallCompany)
    val bigCompany: Company[BigCompany] = new Company[BigCompany](new BigCompany)
    val bigInvestor: Investor = new Investor(bigCompany)

    //  val smallInvestor:Investor = new Investor(littleCompany)
    // error found : Company[SmallCompany] required: Company[BigCompany]
  }

  {
    class Company[+T](val company:T)
    class BigCompany
    class SmallCompany extends BigCompany
    class Investor(val company: Company[BigCompany])

    val littleCompany: Company[SmallCompany] = new Company[SmallCompany](new SmallCompany)
    val bigCompany: Company[BigCompany] = new Company[BigCompany](new BigCompany)
    val bigInvestor: Investor = new Investor(bigCompany)
    val smallInvestor:Investor = new Investor(littleCompany)

  }


}
