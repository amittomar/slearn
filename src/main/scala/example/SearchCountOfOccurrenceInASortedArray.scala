package example


object SearchType extends Enumeration{
  type Search = Value
  //Assigning values
  val FIRST: SearchType.Value = Value("first")
  val LAST: SearchType.Value = Value("last")
}

/**
 * Time complexity : 0(log(n)) && space complexity 0(1)
 * FaceBook interview question to find number of occurrence in a sorted array
 */
object SearchCountOfOccurrenceInASortedArray {
  private val NOT_FOUND: Int = -1


  def main(args: Array[ String ]): Unit = {
    val array: Array[Int] = Array(1,4,5,6,7,7,7,8,9,9)
    val element = 9
    print(search(array,element))
  }


  def isIndexExist(array: Array[Int], x: Int):Boolean = {
    val end = array.length -1
    x >=0 && x <= end
  }

  def binarySearch(array: Array[Int], element:Int, left: Int, right: Int, searchType: SearchType.Value):Int = {
    if(array.length == 0 || left > right) return NOT_FOUND

    //calculate mid and not overFlow
    /** TODO : understand the overflow in case of assign mid = left+right/2 */
    val mid: Int = left + (right - left) / 2

    if(array(mid) == element){
      if(isIndexExist(array,mid -1) && searchType == SearchType.FIRST && array(mid) == array(mid -1)){
          return binarySearch(array,element,left,mid-1,searchType)
      }
      else if(isIndexExist(array,mid+1) && searchType ==SearchType.LAST && array(mid) == array(mid+1)){
        return binarySearch(array,element,mid+1,right,searchType)
      }
      mid
    }
    else if(array(mid) < element){
      binarySearch(array,element,mid+1,right,searchType)
    } else if(array(mid) > element){
      binarySearch(array,element,left,mid-1,searchType)
    }
    else NOT_FOUND
  }

  def search(array: Array[Int], element: Int): Int = {
    val firstOccurrence: Int = binarySearch(array,element,0,array.length -1,SearchType.FIRST)
    if(firstOccurrence == -1){
       firstOccurrence
    } else{
      val lastOccurrence: Int = binarySearch(array,element,0,array.length -1,SearchType.LAST)
       lastOccurrence - firstOccurrence +1
    }
  }

}
