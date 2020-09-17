package example

class HigherOrderFunctions {
  def sumOfInts(start: Int, end: Int): Int = {
    if (start > end) 0 else start + sumOfInts(start + 1, end)
  }

  def id(x: Int): Int = x

  def cube(x: Int): Int = x * x * x

  def square(x: Int): Int = x * x

  def fact(num: Int): Int = if (num == 0) 1 else fact(num - 1)

  def sumOfCube(start: Int, end: Int): Int = {
    if (start > end) 0 else cube(start) + sumOfCube(start + 1, end)
  }

  def sum(f: Int => Int, start: Int, end: Int): Int = {
    if (start > end) 0
    else f(start) + sum(f, start + 1, end)
  }

  def sumOfIntsH(start: Int, end: Int): Int = sum(x=>x, start, end)

  def sumOFCubesH(start: Int, end: Int): Int = sum(x=>x*x*x, start, end)


  def sumOfFactorials(start: Int, end: Int): Int = sum(fact, start, end)

}
  object starter extends App{
    val function = new HigherOrderFunctions()
    print(function.sumOfInts(1,5))
  }

