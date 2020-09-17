package example

object tailRecursive  extends App {

  def sum(f: Int =>Int, start:Int, end:Int) : Int ={
      def loop(start:Int, accumulator: Int):Int ={
        if(start > end) accumulator
        else  loop(start+1, f(start)+accumulator)
      }
    loop(start, 0)
  }

//  println (sum(x=>x*x*x, 3,50))
//  println (sum(x=>x*x, 3,50))
//  println (sum(x=>x, 3,50))


  ///// Functions returning Functions


  def product(f: Int => Int)(start: Int, end : Int): Int =
    if (start > end) 1
    else f(start)* product(f)(start+1,end)

// println(product(x=>x*x)(3,4))

  def fact(n: Int) = product(x=>x)(1,n)

 // print(fact(5))


  def mapReduce(f: Int =>Int, combine: (Int,Int) =>Int,zero :Int)(a:Int, b:Int): Int =
    if(a>b) zero
    else combine(f(a), mapReduce(f, combine,zero)(a+1,b))


  def factorialTaikRecursive(n : Int, acc : Int): Int ={
    if(n == 0 || n ==1 ) acc
    else factorialTaikRecursive(n-1,n*acc)
  }

  def factT(n :Int):Int = factorialTaikRecursive(n,1)

  println(factT(3))
}
