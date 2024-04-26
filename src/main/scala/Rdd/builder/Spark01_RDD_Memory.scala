package Rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark01_RDD_Memory {
  def main(args: Array[String]): Unit = {
    //  准备环境
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(conf)
    //  创建RDD
    val seq = Seq[Int](1, 2, 4 ,6)

    //  parallelize:并行
//    val rdd = sc.parallelize(seq)
    val rdd = sc.makeRDD(seq)
    rdd.collect().foreach(println)
    //  关闭环境
    sc.stop()
  }
}
