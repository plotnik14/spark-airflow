package com.alexp

import org.apache.spark.sql.functions.lit
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object MyJob {
  private val spark = SparkSession.builder
    .appName("SparkAirflowTask")
//    .master("local[*]")
    .config("spark.sql.shuffle.partitions", 16)
    .getOrCreate()

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    Seq(
        (1, "Alex"),
        (2, "Palex"),
        (3, "Lalex"),
        (4, "Vova"),
        (5, "Nova")
      ).toDF("id", "name")
      .show()


    spark.stop()
  }
}
