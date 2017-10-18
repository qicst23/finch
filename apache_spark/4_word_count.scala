import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._


Logger.getLogger("org").setLevel(Level.ERROR)

val sc = new SparkContext("local[*]", "WordCount")   

val lines = sc.textFile("/Users/zhedongzheng/tutorials/apache_spark/temp/Book.txt")

val words = lines.flatMap(x => x.split(" "))

val wordCounts = words.countByValue()

wordCounts.foreach(println)