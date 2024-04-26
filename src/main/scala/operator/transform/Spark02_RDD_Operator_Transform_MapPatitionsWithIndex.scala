package operator.transform

import org.apache.spark.{SparkConf, SparkContext}

object Spark02_RDD_Operator_Transform_MapPatitionsWithIndex {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("RDD")
    val sc = new SparkContext(conf)
    val rdd = sc.makeRDD(List(1,2,3,4),2)
    //  假如只要第二个分区的数据
    rdd.mapPartitionsWithIndex(
      (index, iterator)=>{
        if (index == 1){
          iterator
        }else{
          Nil.iterator
        }
      }
    ).collect().foreach(println)

  }
}
