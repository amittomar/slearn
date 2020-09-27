package example

object Extensions {
    def positiveMod (m: Int,n:Int):Int ={
      (m % n)
    }

  def main(args: Array[ String ]): Unit = {
    print(positiveMod(25,10))
  }
}
