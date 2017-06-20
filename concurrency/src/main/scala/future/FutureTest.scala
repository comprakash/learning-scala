package future

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by Om Prakash C  on 16-06-2017.
  */
object FutureTest extends App {
  println("This is first.")
  val f = Future {
    println("Printing in the future.")
  }
  Thread.sleep(1)
  println("This is last.")
  Thread.sleep(5000)
}
