package example

import scala.collection.mutable.ListBuffer

object StringPermutations {

  def allPermutation(str: String, left: Int, end: Int, result: ListBuffer[ String ]): Unit = {
    if (left == end) result += String.valueOf(str)
    else {
      for (i <- left to end) {
        val swapped = swap(str, left, i)
        allPermutation(swapped, left + 1, end, result)
      }
    }
  }

  def swap(str: String, i: Int, j: Int): String = {
    val input: Array[ Char ] = str.toCharArray
    val temp: Char = input(i)
    input(i) = input(j)
    input(j) = temp
   return String.valueOf(input)
  }

  def main(args: Array[ String ]): Unit = {
        val result:ListBuffer[String] = new ListBuffer[String]
        val input = "BACD"
        val right = input.length -1
        allPermutation(input,0,right,result)
        result.toSet.foreach(println)
        println(result.toSet.size)

  }
}
