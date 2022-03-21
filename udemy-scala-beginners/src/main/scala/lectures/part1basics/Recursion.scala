package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  def factorial(n: Int): BigInt =
    if (n <= 1) 1
    else n * factorial(n - 1)

  // println(factorial(7000)) // java.lang.StackOverflowError

  def factorialTailRecursion(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) // Tail Recursion = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  println(factorialTailRecursion(7000))

  def concatString(inputString: String, n: Int): String = {
    @tailrec
    def concatStringHelper(inputString: String, n: Int, accumulator: String): String =
      if (n <= 0) accumulator
      else concatStringHelper(inputString, n - 1, accumulator + inputString)

    concatStringHelper(inputString, n, "")
  }

  println(concatString("Om ", 5))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(n: Int, acc1: Int, acc2: Int): Int =
      if (n <= 2) acc2
      else fibonacciHelper(n - 1, acc2, acc1 + acc2)
    fibonacciHelper(n, 1, 1)
  }

  // 1 1 2 3 5 8 13 21 34
  println(fibonacci(9))

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, isStillPrime: Boolean): Boolean =
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeHelper(t - 1, n % t != 0 && isStillPrime)

    isPrimeHelper(n / 2, true)
  }

  println(isPrime(2003))

}
