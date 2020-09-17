package example

import scala.collection.mutable.ListBuffer

object StringPermutations {

  def allPermutation(str: String, left: Int, end: Int, result: ListBuffer[ String ]): Unit = {
    if (left == end) result += String.valueOf(str)
    else {
      for (i <- left to end) {
        var swapped = swap(str, left, i)
        allPermutation(swapped, left + 1, end, result)
      }
    }
  }

  def swap(str: String, i: Int, j: Int): String = {
    var input: Array[ Char ] = str.toCharArray
    var temp: Char = input(i)
    input(i) = input(j)
    input(j) = temp
    return String.valueOf(input)
  }

  def main(args: Array[ String ]): Unit = {
        val result:ListBuffer[String] = new ListBuffer[String]
        val input = "BAC"
        val right = input.length -1
        allPermutation(input,0,right,result)
        result.toSet.foreach(println)
        println(result.toSet.size)

//    val x = new ListBuffer[ Int ]
//    fib(5, x)
//    println("************")
//    x.toSet.foreach(println)

  }

  def fib(n: Int, acc: ListBuffer[ Int ]): Int = {

    if (n == 1) {
      acc += 0; return 0;
    }
    else if (n == 2) {
      acc += 1; return 1
    }
    else {
      var x :Int = 0
      x =  fib(n - 1, acc) +fib(n-2,acc)
      acc+=x
      return x
    }


  }
}
