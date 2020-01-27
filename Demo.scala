package basics

object Demo {
  // function declaration type 1
  def add(x: Int, y: Int): Int ={x+y}
  println(add(34,43))
  
  //function declaration type 2
  def add1:(Int ,Int) => Int = (i,j) => {i+j}
  println(add1(12,34))
  
  //function declaration type 3
   val suare:Double => Double = x => x*x
   println(suare(5))
   //function declaration type 4 (anonymus funcion
   val square = (x:Double) => x*x
    println(square(6))
 // Higher order functions
   /**
    * takes function as parameter and return a function
    * 
    */
   
   def math(x: Int , y: Int, 
    f: (Double,Double)=> Double):
      Double = f(x,y)
   
  def main(args: Array[String]): Unit = {
    
       val result = math(50,20,(x,y) =>  x+y)
     
     //partially applied function 5  
    val sum = (x: Int, y: Int, z: Int) => x+y+z
    val result1 = sum(10,20, _ : Int)    
    println(result1(100))
  //  clousers   6
    /**
     * function which uses one or 
     * more variables declared out
     * side this function 
     */

    var number = 10
    val add = (x: Int) =>x + number    
    println(add(20))
    
   // currying function
  }
}