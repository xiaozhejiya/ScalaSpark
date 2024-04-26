package operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_Operator_Transform_MapPatitions_Test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)
    // 取出分区的最大数
    rdd.mapPartitions(
      iter => {
        List(iter.max).iterator
      }
    ).collect()
  }
}
