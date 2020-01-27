package basics



object test {
  
  def main(args: Array[String]): Unit = {
    val map = Map("801"->"PK", "802"->"AK","803"->"JK")
    map.keys.foreach(x => if(map.keys == "803") println(map(x)))
    
  val a = List(1,2,3,4,5,6)
  
  a.foreach(x => if (x <4 || x >5) x match{
    // case 1 | 2 | 3| 4| 5 | 6 => println("available value 1,2,3,4,5,6")
     case 1 =>println("one")
     case 2 =>println("two")
     case 3 =>println("three")
     case 4 =>println("four")
     case 5 =>println("five")
     case 6 =>println("six")
   
        }  )
  
  
   for (x <- a if x <4 || x >5){
   
   x match{
    // case 1 | 2 | 3| 4| 5 | 6 => println("available value 1,2,3,4,5,6")
     case 1 =>"one"
     case 2 =>"two"
     case 3 =>"three"
     case 4 =>"four"
     case 5 =>"five"
     case 6 =>"six"
   
        }  
 println(x) 
      } 

   }  
}