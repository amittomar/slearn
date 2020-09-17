package example

import java.util

import scala.collection.convert.ImplicitConversions.`collection asJava`
import scala.collection.mutable
import scala.collection.mutable.ListBuffer


object NQueen extends App {

   override def main(args: Array[ String ]): Unit = {

     val data = solveNQueen(4)


     for(list : List[Int] <- data){
       println("***************************** solution **********************")
       list.foreach(println)
       }


  }

  def solveNQueen(n:Int): List[List[Int]] = {

    val results = new mutable.MutableList[List[Int]]()
    var placement = new ListBuffer[Int]

    def solve(n: Int, row: Int, placement: ListBuffer[ Int ], result: mutable.MutableList[ List[ Int ] ]): Unit = {
      //Our Goal
      if (row > n) {
        result += placement.toList
      }
      else {
          var col =1
        while (col <= n) {
          placement += col                                  // Choice
          if (isValid(placement.toList)) {                    //Constraint
            solve(n, row + 1, placement, result)
          }
          placement.remove(placement.size - 1)               // remove choice if not correct
          col +=1
        }

      }
    }


    def isValid(placement: List[ Int ]): Boolean = {
      var rowID:Int = placement.size -1
      var i =0
      while (i < rowID) {
        val diff = Math.abs(placement(i) - placement(rowID))
        if (diff == 0 || diff == rowID-i) {
          return false
        }
        i+=1
      }
      return true
    }
    solve(n,1,new ListBuffer[Int](),results)
    return results.toList
  }

  def isValid(placement: List[ Int ]): Boolean = {
    var rowID:Int = placement.size -1
    var i =0
    while (i < rowID) {
      val diff = Math.abs(placement(i) - placement(rowID))
      if (diff == 0 || diff == rowID-i) {
        return false
      }
      i+=1
    }
    return true
  }
}




