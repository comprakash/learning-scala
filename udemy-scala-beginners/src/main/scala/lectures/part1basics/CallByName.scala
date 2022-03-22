package lectures.part1basics
import scala.collection.mutable

object CallByName extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  val x = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
  def appendElement(m: mutable.Map[String, Int]): Unit = {
    m += ("d" -> 4)
  }
  appendElement(x)
  println(x)
}
