package basics

object currying {
  def main(args: Array[String]): Unit = {
    
    def sum(num1: Int)=(num2: Int)=> num1+num2
    
    
   val s = sum(10)
   val r = s(2)
   
   // using partially applied function
   def add(num1: Int)(num2: Int)= num1+num2
   val r1 = add(10) _
   val r2 = r1(2) 
    
    
  }
}