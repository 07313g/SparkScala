package basics

object daigonalDiff {
  def diagonalDifference(arr: Array[Array[Int]]): Int = {
    // Write your code here
 
   var sumMaxD = 0;var sumMinD=0  
    for (i <- 0 to arr.length-1;j <- 0 to arr.length-1 )
    {      
              
        if(i==j){
        sumMaxD+=arr(i)(j)
        
        }               
        sumMaxD
        
         if((i+j) == arr.length-1){
        sumMinD+=arr(i)(j)
        
        }               
      sumMinD
        
      
      
    }  
       val res = (sumMaxD-sumMinD).abs
       res
    }  
}

object Solution {
    def main(args: Array[String]) {
       // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
       val StdIn = scala.io.StdIn
        val n = StdIn.readLine.trim.toInt

        val arr = Array.ofDim[Int](n, n)

        for (i <- 0 until n) {
            arr(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
        }

        val result = daigonalDiff.diagonalDifference(arr)

       println(result)

           }
}