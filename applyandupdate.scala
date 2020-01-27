package basics

object applyandupdate {
 def main(args: Array[String]) = {
   var store = Map("1"-> "Jphn","2"->"Mike","3"->"Albe")
    
  //  def apply(id: String) = store(id)
    println(store)
    
    println(store.apply("1"))
    println(store.updated("4", "[lovely,lon]"))
    
  }
}