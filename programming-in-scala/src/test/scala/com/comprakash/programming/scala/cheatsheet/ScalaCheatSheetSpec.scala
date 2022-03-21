package com.comprakash.programming.scala.cheatsheet

import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

class ScalaCheatSheetSpec extends AnyFlatSpec with Matchers {
  "The Evaluated Immediately" should "contain 2" in {
    ScalaCheatSheet.evaluatedImmediately shouldEqual 2
  }
}
