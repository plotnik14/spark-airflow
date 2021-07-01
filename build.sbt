name := "spark-airflow"

version := "0.1"

scalaVersion := "2.11.12"
val sparkVersion = "2.3.1"

idePackagePrefix := Some("com.alexp")


val excludeJpountz = ExclusionRule(organization = "net.jpountz.lz4", name = "lz4")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion /*% "provided"*/,
  "org.apache.spark" %% "spark-sql" % sparkVersion /*% "provided"*/,
  "org.apache.spark" %% "spark-streaming" % sparkVersion /*% "provided"*/,
  "org.apache.spark" %% "spark-sql-kafka-0-10" % sparkVersion excludeAll(excludeJpountz),
  "com.databricks" %% "spark-avro" % "4.0.0",
  "com.typesafe" % "config" % "1.4.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)

assemblyMergeStrategy in assembly := {
  case "reference.conf" => MergeStrategy.concat
  case "META-INF/services/org.apache.spark.sql.sources.DataSourceRegister" => MergeStrategy.concat
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}