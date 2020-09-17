package example

import org.scalatest.FunSuite

class HigherOrderFunctionsTest extends FunSuite {

  test("testSum") {
    val fun = new HigherOrderFunctions()
    assertResult(15)  {
      fun.sumOfInts(1,5)
    }

  }

}
