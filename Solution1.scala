package basics

import java.io.PrintWriter



object Solution1 {
  /*
     * Complete the simpleArraySum function below.
     */
    def simpleArraySum(ar: Array[Int]): Int = {
        
        /* * Write your code here.
         */
   /* var sum = 0
  var i = 0
  while (i<ar.length) { sum += ar(i); i += 1 }
  sum*/
      var sum =0
       ar.foreach(sum += _)
        sum
       // println(sum)
      
    }

    // Complete the compareTriplets function below.
    def compareTriplets(a: Array[Int], b: Array[Int]): Array[Int] = {
       var bob=0
       var alice =0
       var i =0
      while(i<a.length){
      if (a(i)<b(i))     
         bob+=1
      if (a(i)>b(i))     
         alice+=1   

      }
     var res =  Array(alice , bob)
     res
    }
    
    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

       val arCount = stdin.readLine.trim.toInt

        val ar = stdin.readLine.split(" ").map(_.trim.toInt)
        val result = simpleArraySum(ar)
       println(result)
      
                
    }
}