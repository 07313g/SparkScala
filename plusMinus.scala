package basics



object plusMinus {
  
  
   // Complete the plusMinus function below.
    def plusMinusfunc(arr: Array[Int]) {
     var negcount=0;var poscount =0 ; var zerocount = 0
   for (i <- 0 to arr.length-1 )
    {  
     
      if(arr(i) < 0) {    
       negcount += 1         
    }              
        negcount
     
    if(arr(i) == 0)   {     
       zerocount += 1         
        }               
        zerocount
        
      if(arr(i) > 0)   {     
       poscount += 1         
        }               
        poscount   
        
    }
     
    val pernegcount =negcount/arr.length.toDouble
    val perzerocount= zerocount/arr.length.toDouble
    val perposcount = poscount/arr.length.toDouble 
    println(s"pernegcount =: $pernegcount  perzerocount =: $perzerocount  perposcount =: $perposcount  ")
 }
    
    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        val arr = stdin.readLine.split(" ").map(_.trim.toInt)
        plusMinusfunc(arr)
    }
}
