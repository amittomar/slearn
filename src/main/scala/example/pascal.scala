package example

import scala.collection.mutable


object Main {

  /*
  C(n,k) = c(n-1,k-1) +c(n -1 ,k)
  c(n,0) = c(n,n) =1
C   */
  def pascal(n:Int, k:Int): Int ={
    val results = new mutable.HashMap[(Int,Int),Int]()


//    def lookup(n:Int,k:Int):Int

    if( k==0 || k== n) 1
    else pascal(n-1,k-1) +pascal(n-1, k)
  }

  def pascall(c:Int, r:Int): Int ={
    val results = new mutable.HashMap[(Int,Int),Int]()


    //    def lookup(n:Int,k:Int):Int

    if( r==0 || r== c) 1
    else pascal(c-1,r-1) +pascal(c-1, r)
  }
//
//  def allCombination(arr : Array[String]):List[Array[String]] ={
//    val aggData = new mutable.LinkedList[Array[String]]()
//    def combination(start : Int, data : Array[String], combination: List[Array[String]]):List[Array[String]] = {
//      if(start == data.size) combination
//      else combination(start,data,combination) + combination(start+1, data,combination )
//    }
//    combination(0,arr,aggData)
//  }


  def main(args: Array[ String ]): Unit = {

    print(pascal(4,2))

  }
}