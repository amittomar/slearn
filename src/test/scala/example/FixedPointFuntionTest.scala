package example

import org.scalatest.FunSuite

class FixedPointFuntionTest extends FunSuite {

  test("testFixedPoint") {
    println(FixedPointFuntion.fixedPoint(x=> math.pow(x,2) -3*x+4)(firstGuess = 1))

  }

}
