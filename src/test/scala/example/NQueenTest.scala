package example


import org.scalatest.FunSuite
import org.scalatest.Matchers.{be, convertToAnyShouldWrapper}




class NQueenTest extends FunSuite {

  test("testSolveNQueen") {
    assert(NQueen.isValid(List(2,4,1,3)),"Must return true")
 }

  test(testName = "positive solution"){
    assert(NQueen.isValid(List(3,1,4,2)))
  }

}