package example
/** TODo Class needs cleaning.  */
class MyClass(x: Int,y:Int) {

  require(y>0,"Y must be positive")

  def sum(x: Int, y: Int) = x + y
  def nb1 = x
  def nb2 =y
  private def test(a:Int) = a*2
  val nnb3 = x + y

  override def toString: String =  x + ", " + y
}

abstract class TopLevel {     // abstract class
  def method1(x: Int): Int   // abstract method
  def method2(x: Int): Int = {
    println("TopLevel"+getClass+"method2")
    return  x+2
  }
}

class Level1 extends TopLevel {
  def method1(x: Int): Int = { println("Leve1.method1")
  return x + 1}
  override def method2(x: Int): Int = { println("Overriden method2")
  return  x } // TopLevel's method2 needs to be explicitly overridden
}

object myObject extends TopLevel {

  override def toString: String = super.toString

  override def method1(x: Int): Int = {
    println("MyObject : method1")
    return x
  } // defines a singleton object. No other instance can be created
}

private class Operator1[ T <: Int](x:T, y:T) {
  require(x > 0 & y > 0, "X must be positive")
  def opr(x:T,y:T) = x - y
}


object test{
  val fun1: PartialFunction[String,String] = {case "ping" =>"pong"}

  val fun2 : PartialFunction[List[Int], String] = {
    case Nil => "One"
    case x :: y :: rest => "two"
  }

  val fun3: PartialFunction[List[Int], String] = {
    case Nil => "One"
    case x :: rest =>
      rest match {
        case Nil => "two"
      }
  }
}


object runner extends App {

  case class Book(title :String, authors : List[String])

  def createBooks() = {
    List(
      Book("Structure and interpretation of Compuetr progreams", authors = List("Abelson Herald", "Amit tomar")),
      Book(title = "Introduction to functional Programing", authors = List("Birds,Richard", "Walders, phil")),
      Book(title = "Effective java", authors = List("Bloucha , Joshua")),
      Book(title = "Java Puzzlers", authors = List("Bloucha , Joshua", "gafter , Neal")),
      Book(title = "Programing in scala", List("OrderSky , MArtin", "Spoon, Lex", "Venners, bill"))
    )
  }

   val books = createBooks()

    //  val obj = new MyClass(3,4)
    //  println(obj)
    //  val x = new Operator1[Int](4,5)
    //  print(x.opr(4,50))
    //  myObject.method1(20)
    //  myObject.method2(24)
    //  println(test.fun1("ping"))
    //  println(test.fun1.isDefinedAt("ping"))
    //  println(test.fun1.isDefinedAt("lx,kb"))
    //  println(test.fun2.isDefinedAt(List(1,2,3,4,5)))
    println(test.fun3.isDefinedAt(List(1, 2, 3)))
    //
    //  List[Book] books  = createBooks();
   // println(searchBookWithAuthorNameBird(books))
  val list = getBookTtileWhoWriteTwoBooks(books)
  list.foreach(println)


  private def searchBookWithAuthorNameBird(books: List[Book]) = {
    for (b <- books; a <- b.authors if a startsWith ("Bird"))
      yield b.title
  }

  private def getBookTtileWhoWriteTwoBooks(books : List[Book]) = for {b1<-books
                                                                      b2 <-books
                                                                      a1 <- b1.authors
                                                                      a2 = b1.authors
                                                                      if  a1 == a2} yield a1
}

