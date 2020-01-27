package basics
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.log4j.LogManager
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.Level
object tempconversion {
  
   def  tempconv(temp:Double): Double = temp*9/5+32   
   val tempf = functions.udf(tempconv _)    
   
 val temp_in_F =  functions.udf((d:Double) =>  {
     d*5/9+32
   })
  
  def main(args: Array[String]): Unit = { 
   
   val spark = SparkSession.builder().appName("TempConversion").
               master("local[*]").enableHiveSupport().getOrCreate()
               
     val df = spark.read.format("json").
     option("inferSchema", true).option("header", true).
    // load("C:\\Users\\PC\\Downloads\\temperatures.json")
     load("/OOScala/resources/temperatures.json")  
  
     import spark.implicits._
     df.select(temp_in_F($"avgHigh"), temp_in_F($"avgLow")).show
     df.select($"*",temp_in_F($"avgHigh"), temp_in_F($"avgLow")).show
     df.select($"*",tempf($"avgHigh").as("avgHighin_f"), tempf($"avgLow").as("avgLowin_f")).show
     
     
}

 

 
}