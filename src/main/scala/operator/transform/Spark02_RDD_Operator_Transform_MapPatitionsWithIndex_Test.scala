package operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_Operator_Transform_MapPatitionsWithIndex_Test {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4))
    //  还可以实现查看数据分区
    rdd.mapPartitionsWithIndex(
      (index, iterator)=>{
        iterator.map((_,index))
      }
    ).collect().foreach(println)

  }
}
