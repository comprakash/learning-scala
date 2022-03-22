package lectures.part2oop

object OOBasics extends App {
  val person = new Person("Vyom", 3)
  // println(person.name) // class parameters are NOT fields, unless prefixed with val or var
  println(person.age)
  println(person.x)
  println(person.greet("Prakash"))
  println(person.greet())

  val author = new Writer("Om", "Prakash", 1900)
  val novel = new Novel("Upcoming", 2050, author)

  println(novel)
  println(author.fullName)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.copy(2100))

  val counter = new Counter
  println(counter.increment.value)
  println(counter.increment(5).value)
  
}

class Person(name: String, val age: Int) {
  val x = 2

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  def greet(): Unit = println(s"Hi, I am $name")

  //multiple constructors, can be replaced with default parameters
  def this(name: String) = this(name, 0)

  def this() = this("Om")
}

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName: String = firstName + " " + surName
}

class Novel(name: String, year: Int, var author: Writer) {
  def authorAge: Int = year - author.year

  def isWrittenBy(author: Writer): Boolean = this.author.equals(author)

  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

class Counter(val value: Int = 0) {
  def currentCount(): Int = value

  def increment = new Counter(value + 1)

  def decrement = new Counter(value - 1)

  def increment(amount: Int) = new Counter(value + amount)

  def decrement(amount: Int) = new Counter(value - amount)
}
