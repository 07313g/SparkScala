package basics
class User( var name: String, var age: Int)
/*{
  def printName { println(name)}
}*/

object Demo1 {
  def main(args: Array[String]): Unit = {
    var user = new User("max",28)
    println(user.name)
   println( user.age)
    
    
    
  }
}