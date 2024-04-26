package Spark.Partition

import org.apache.spark.{SparkConf, SparkContext}

object Test_02Rdd_Function {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Test")
    val sc = new SparkContext(conf)
    val lines = sc.textFile("hdfs://10.3.15.116:8020/word.txt")
    //  reduceByKey.根据键进行分组并对值进行计算
      val rdd = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_ + _)
    //  即使不是用reduceByKey,也可以实现单词统计
    //  val rdd = lines.flatMap(_.split(" ")).groupBy(data => data).map(a => (a._1,a._2.toList.length))
    //  获取所有的键
    //  val rdd = lines.flatMap(_.split(" ")).map((_,1)).keys
    //  获取所有的值
    //  val rdd = lines.flatMap(_.split(" ")).map((_,1)).values
    //  根据键排序
    //  rdd.sortByKey().foreach(println)
    //  指定排序规则
    rdd.sortBy(_._2,false).collect().foreach(println)
    //  只对值进行操作
    rdd.mapValues(_ + 1).sortBy(_._2,false).collect().foreach(println)
    //  join操作,只要键相同就会对值进行组合
    val rdd2 = sc.parallelize(Array(("spark","hadoop")))
    rdd.join(rdd2).collect().foreach(println)
    sc.stop()
  }
}
