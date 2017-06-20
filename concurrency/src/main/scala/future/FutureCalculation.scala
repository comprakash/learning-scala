package future

import multithreading.ParallelCollection

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by Om Prakash C  on 16-06-2017.
  */
object FutureCalculation extends App {
  println("This is first.")
  val f = Future {
    for (i <- 1 to 30) yield ParallelCollection.fib(i)
  }
  f.onComplete {
    case Success(n) => println(n)
    case Failure(ex) =>
      println("Something went wrong")
      println(ex.getMessage)
  }
  Thread.sleep(1)
  println("This is last.")
  Thread.sleep(1000)
}
