package basics

import org.apache.spark._
import org.apache.spark.sql._
import org.apache.log4j.LogManager
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.log4j.Level

object sparkExcercise {
  def main(args: Array[String]): Unit = {
    
  Logger.getLogger("org").setLevel(Level.OFF)
Logger.getLogger("akka").setLevel(Level.OFF)
    val spark = SparkSession.builder().appName("SparkExample").master("local[*]")
                .enableHiveSupport().getOrCreate()
                
         val dfTags = spark.read.option("header",true).
option("inferSchema",true).format("csv").
load("C:\\Users\\PC\\Downloads\\question_tags_10K.csv")  

 dfTags.filter("tag =='php' and id between 5  and 500").show
 
 dfTags.groupBy("tag").count()
 import spark.implicits._
 dfTags.groupBy("tag").count().filter("count >5").sort($"tag".desc).show()
 
 
 val dfQuestionsCSV = spark.
 read.
 option("header", "true").
 option("inferSchema", "true") .
 option("dateFormat","yyyy-MM-dd HH:mm:ss") .
 csv("C:\\Users\\PC\\Downloads\\questions_10K.csv") .
 toDF("id", "creation_date", "closed_date", "deletion_date", "score", "owner_userid", "answer_count")
 
 dfQuestionsCSV.printSchema()
 //specific conversion of datatype
 
 val dfQuestions = dfQuestionsCSV.select(
     dfQuestionsCSV("id").cast("integer"),
     dfQuestionsCSV("creation_date").cast("timestamp"),
     dfQuestionsCSV("closed_date").cast("timestamp"),
     dfQuestionsCSV("deletion_date").cast("date"),
     dfQuestionsCSV("score").cast("integer"),
     dfQuestionsCSV("owner_userid").cast("integer"),
     dfQuestionsCSV("answer_count").cast("integer")
     
     )
 dfQuestions.printSchema()
 
 val dfQuestionsSubset = dfQuestions.filter("score > 400 and score < 410")
  dfQuestionsSubset.show()
 
 dfQuestionsSubset.join(dfTags, "id").show(10)
 
 dfQuestionsSubset.
 join(dfTags, "id").
 select("owner_userid", "tag", "creation_date", "score").
 show(10)
 
  import spark.implicits._ //so that you could use .toDF
        val df = Seq(
          ("steak", 1, 1, 150),
          ("steak", 2, 2, 180),
          ("fish", 3, 3, 100)
        ).toDF("C1", "C2", "C3", "C4")
        
        import org.apache.spark.sql.functions._
        
        // 1st approach using expr
        df.withColumn("C5", expr("C2/(C3 + C4)")).show()
        
        // 2nd approach using selectExpr
        df.selectExpr("*", "(C2/(C3 + C4)) as C5").show()
        
        // 3rd approach 
        df.withColumn("C5", $"C2" / $"C3"+$"C4").show(false)
        // 4th Approach
        df.select($"col1", $"col2", ($"col3" + $"col4").as("col3")).show(false)
        //5th Approach
        df.withColumn("name", lit("pushpak"))
        
        //6th approach 
        df.withColumn("C5", df("C2")/df("C3")+df("C4")) .show()
        
        //UDF function
        // 1st Approach
        def addPrefix(s:String) : String =s"so_$s"
        spark.udf.register("prefix_so",addPrefix _)
        spark.sql("select prefix_so(tag) from so_tags ").show
        
        //2nd Approach
        val removeChars = functions.udf((s:String) => {
         s.replaceAll("\\(","")
          .replaceAll("\\[","")
          .replaceAll("\"","")
          .replaceAll("\\]", "")
          .replaceAll("\\)", "")
          
})
  
df.withColumn("removedchar", removeChars(df.col("_c0"))).show()
df.select(removeChars($"_c0"),removeChars($"_c1"),removeChars($"_c2")).show() 
val add = udf(addPrefix _)
df .select (add($"_c0")).show()
// another approach for creating udf for 
val remove =udf{s:String => 
  s.replaceAll("\\(","")
          .replaceAll("\\[","")
          .replaceAll("\"","")
          .replaceAll("\\]", "")
          .replaceAll("\\)", "")
        
  }
  
  
  
  val dftab = spark.read.csv("C:\\Users\\PC\\Downloads\\file2.txt").toDF("columnToSplit")
  
  dftab.withColumn("_tmp", split($"columnToSplit", " ")).select(
  $"_tmp".getItem(0).as("col1"),
  $"_tmp".getItem(1).as("col2"),
  $"_tmp".getItem(2).as("col3")
).drop("_tmp").show()
    
//or you can use  
  dftab.withColumn("_tmp", split($"columnToSplit", " ")).select(
(0 until 3).map(i => col("temp").getItem(i).as(s"col$i")): _*
).show

//or to Keep all Column
dftab.withColumn("_tmp", split($"columnToSplit", " ")).select(
col("*") +: (0 until 3).map(i => col("temp").getItem(i).as(s"col$i")): _*
).show

//Pipeseparated file to load as dataframe

val dfpipe = spark.read.format("csv").
option("inferSchema", true).
option("delimiter","|").
load("C:\\Users\\PC\\Downloads\\file2.txt").
toDF("c1","c2","c3")

dfpipe.write.format("csv").option("delimiter", "|").mode("overwrite").
save("C:\\Users\\PC\\Downloads\\file3.txt")
  }
}