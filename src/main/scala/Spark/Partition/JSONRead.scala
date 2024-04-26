package Spark.Partition


import scala.util.parsing.json.JSON
import org.apache.spark.{SparkConf, SparkContext}

object JSONRead {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("jsonRead")
    val sc = new SparkContext(conf)
    val json = sc.textFile("hdfs://10.3.15.116:8020/people.json")
    val result = json.map(s => JSON.parseFull(s))
    result.foreach({
      r => r match {
        case Some(map:Map[String, Any]) => println(map)
        case None => println("Parsing failed")
        case other => println("Unknown data structure" + other)
      }
    })
  }
}
