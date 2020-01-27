package basics

object compareTriplet {
  
   def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
       var bob=0
       var alice =0
       var i =0
       
      while(i<a.length){
      if (a(i)<b(i)){
        bob+=1
        }
         
      if (a(i)>b(i)) {
        alice+=1
        } 
         
          i+=1
      }  
        
       var res =  Array(alice , bob)
             res
    }
   
   def main(args: Array[String]) {
     val stdin = scala.io.StdIn
   val a = stdin.readLine.split(" ").map(_.trim.toInt)
      // print(a)
       val b = stdin.readLine.split(" ").map(_.trim.toInt)
       //print(b)
        val result1 = compareTriplets(a, b)
       // println(result1)
      println(result1.mkString(" "))
       
        


   }
  
}