package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"${name}, what the heck?"
    def isAlive : Boolean = true
    def apply(): String = s"Hi, my name is ${name} and I like $favouriteMovie."
  }

  val vyom = new Person("Vyom", "Swades")
  println(vyom.likes("Swades"))
  println(vyom likes "Swades")

  // infix notation = operation notation (syntactic sugar)
  val prakash = new Person("Prakash", "Interstellar")
  println(prakash + vyom)

  println(1.+(2))
  // All operators are methods

  // prefix notation -
  val x = -1 // equivalent with 1.unary_-
  // unary_ prefix works with - + ~ !
  println(!vyom)

  // postfix notation
  println(vyom isAlive)

  // apply
  println(vyom.apply())
  println(prakash())
}
