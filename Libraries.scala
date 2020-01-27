package basics
import scala.io.StdIn._
import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object Libraries {
  
  def main(args: Array[String]): Unit = {    
  
 val arr = Array (1,2,3,4,5,6)
 val l2 = List(2,3,4,5,6,7,8)
  for (i <- l2)
  {
    println(i)
  }
  arr.foreach{
    i=>
    val sqr = i*i
      println(sqr)
  }
  
  var arrmap = arr.map(i=> i*2)
  arrmap.foreach(println)
  
  
 }
}