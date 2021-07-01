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
  "com.typesafe" % "config" % "1.4.1",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)