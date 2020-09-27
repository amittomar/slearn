package example

import scala.annotation.tailrec

object Gcd {
  /** Euclidean Algorithm
   * GCD(x,y) GCD(x,x % y) if (x > y and y !=0)
   * GCD(x,0) = x
   * @param x Int
   * @param y Int
   * @return Int
   */
  def gcd(x:Int,y :Int):Int ={
    if(x > y) calculateGcd(x,y) else calculateGcd(y,x)

    @tailrec
    def calculateGcd(x:Int, y:Int):Int = {
      if (x != 0 && y == 0) x
      else calculateGcd(y, x % y)
    }
    calculateGcd(x,y)
  }

}
