package com.comprakash.programming.scala.cheatsheet

object ScalaCheatSheet {
  def evaluateWhenCalled = 1
  val evaluatedImmediately = 2
  lazy val evaluateOnceWhenNeeded = 3

  def callByValueCeil(x: Double): Double = x.ceil
  def callByNameSquareRoot(x: => Double): Double = x.ceil
  def myMax(bindings: Int*): Int = bindings.max  // bindings is a sequence of int, containing a varying # of arguments

   sum takes a function that takes an integer and returns an integer then
   returns a function that takes two integers and returns an integer
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumFunction(a: Int, b: Int): Int = f(a) + f(b)
    sumFunction
  }

  // same as above. Its type is (Int => Int) => (Int, Int) => Int
  def sum(f: Int => Int)(a: Int, b: Int): Int = a + b

  // Called like this
  sum((x: Int) => x * x * x)          // Anonymous function, i.e. does not have a name
  sum(x => x * x * x)                 // Same anonymous function with type inferred

  def cube(x: Int) = x * x * x
  sum(x => x * x * x)(1, 10) // sum of 1 cubed and 10 cubed
  sum(cube)(1, 10)           // same as above
}
