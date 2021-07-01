package com.alexp

import org.apache.spark.sql.functions.lit
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object MyJob {
  val PathToInputData = "/airflowfiles/input/"
  val PathToOutputData = "//airflowfiles/output/"

  private val spark = SparkSession.builder
    .master("local[*]")
    .appName("SparkAirflowTask")
    .config("spark.sql.shuffle.partitions", 16)
    .getOrCreate()

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    spark
      .read
      .parquet(PathToInputData)
      .withColumn("myNewColumn", lit("42"))
      .write
      .mode(SaveMode.Overwrite)
      .format("com.databricks.spark.avro")
      .save(PathToOutputData)

    spark.stop()
  }
}
