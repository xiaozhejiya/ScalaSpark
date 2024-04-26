name := "Spark.Partitioner"

version := "1.0"

scalaVersion := "2.12.11"

javacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.2.0",
  "org.apache.spark" %% "spark-sql" % "3.2.0",
//  "org.apache.hbase" % "hbase-client" % "2.5.6",
//  "org.apache.hbase" % "hbase-common" % "2.5.6",
//  "org.apache.hbase" % "hbase-server" % "2.5.6",
//  "org.apache.hadoop" % "hadoop-auth" % "3.3.0",
//
//  "org.apache.hadoop" % "hadoop-common" % "3.3.0",
//  "org.apache.hadoop" % "hadoop-client" % "3.3.0",
//  "org.apache.hadoop" % "hadoop-core" % "3.3.0"
//  "org.apache.hbase" % "hbase-mapreduce" % "2.5.6"
)

