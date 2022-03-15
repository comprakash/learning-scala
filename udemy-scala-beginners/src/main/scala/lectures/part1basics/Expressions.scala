package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)
  println(2 + 3 * 4)
  println(1 == x)
  var aVariable = 5
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(if(aCondition) 5 else 3)

  // Everything in Scala is an Expression, except definition (vals, class, package, etc) are not

  val aWeirdValue: Unit = aVariable = 3 // Unit == void
  print(aWeirdValue) // It has value as ()

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
}
