package example

import scala.annotation.tailrec
import scala.math.abs

object exercise extends App {
  val tolerance = 0.0001
  def isCloseEnough(x:Double,y:Double) =
    abs((x-y)/x)/x < tolerance

  def fixedPoint(f: Double =>Double)(firstGuess: Double)={
    @tailrec
    def iterate(guess: Double):Double ={
      val next = f(guess)
      if(isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

  print(fixedPoint(x=> 1+x/2)(1))

}
