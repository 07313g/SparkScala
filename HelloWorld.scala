

package basics

object HelloWorld {
  
  val name ="pat cook" 
  val value =42
  var age = 22
   age+=1
   val t= (1,2,3,"hi there")
   val notUseful= () 
   println(t._1,t._2,t._3,t._4)
   //val (a,b,c) = t
  println( s"the second element of t is ${t._2} ")
   println(value + age)
   println(value min age)
   print( "pat cook " * 5)
   
   
   
   val square = (x:Double) => x*x
    println(square(5))
   val suare:Double => Double = x => x*x
    println(square(3))
  // def square(x:Double):Double = x*x
     println(square(4))
     val twice:Double => Double =x =>x*3
     println(twice(4))
     val lt:(Double,Double) =>Boolean =_<_
     
 def main(args: Array[String]): Unit = {
   println("Hello world")
   print(name+" "+value+" "+age)
   var i=5
   while(i>=1){
     println("*"*i)
       i-=1
       
println(if(age<18) "it is minor "  else "come on in")
     
val stuff = for {
  i <- 0 to 10
     if i%3==0 || i%5==0
      sqr=i*i
     j<- 'a' to 'c'
}yield
     {
      i->j    
      }
  print(stuff)
    
} 
     
        
 }
}