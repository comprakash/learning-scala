package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      def loop(column: Int, row: Int): Int = {
        if (column>row) 0
        else if (column==0) 1
        else loop(column-1, row-1) + loop(column, row-1)
      }
      loop(c,r)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      @tailrec
      def inner(count: Int, charsSubSet: List[Char]) : Int = {
        if (charsSubSet.isEmpty) count
        else {
          var increment = 0
          if (charsSubSet.head == '(') increment = 1
          else if (charsSubSet.head == ')') increment = -1
          if (count + increment < 0) return increment
          else inner(count + increment, charsSubSet.tail)
        }
      }
      inner(0, chars) == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      //var combinations = money * count(coins)
      def inner(count: Int, coinsSubSet: List[Int]): Int = {
        if (coinsSubSet.isEmpty) 0
        else 1
      }
      inner(0, coins)
    }
  }
