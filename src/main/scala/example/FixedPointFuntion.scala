package example

import scala.annotation.tailrec
import scala.math.abs

/**
 * Approximate a fixed point function.
 * Fixed point function is a function where (x,f(x)) lies on x = y line.
 *
 *
 */
object FixedPointFuntion extends App {
  val tolerance = 0.00001
  def isCloseEnough(x:Double,y:Double) =
    abs((x-y)/x)/x < tolerance

  /**
   *  Given a first guess, Approximate a fixed point function with a defined precision
   */
  def fixedPoint(f: Double =>Double)(firstGuess: Double)={
    @tailrec
    def iterate(guess: Double):Double ={
      val next = f(guess)
      println(next)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  //print(fixedPoint(x=> 1+x/2)(1))
  print(fixedPoint(x=> math.pow(x,2) -3*x+4)(firstGuess = 1))

}
