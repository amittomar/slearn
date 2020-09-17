package example

/**
 * Tower of Hanoi problem
 */
object Hanoi {
   def move(from:String, to:String): Any ={
     println("move disk from "+from+" to "+to)
   }

  private def move(from:String, helper:String, to:String) :Any = {
    move(from,helper)
    move(helper,to)
  }

  def hanoiMoves(n:Int,from:String,helper:String,to:String):Any = {
    if(n ==0 ) return
    hanoiMoves(n-1,from,to,helper)
    move(from,to)
    hanoiMoves(n-1,helper,from,to)

  }

  def main(args: Array[ String ]): Unit = {
    hanoiMoves(4,"A","B","C")
  }

}
