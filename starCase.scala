package basics

object starCase {
  // Complete the staircase function below.
    def staircase(n: Int) {
    for(k <- 1 to n){
          for(i <- 1 to n-1){
              print(" ")
              
              for(i<- 1 to 2*k-1){
                print("#")}
          }
          
          println("")
          
      }

    }

    def main(args: Array[String]) {
        val stdin = scala.io.StdIn

        val n = stdin.readLine.trim.toInt

        staircase(n)
    }
}