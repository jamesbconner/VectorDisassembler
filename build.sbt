import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.apache.spark.ml.feature",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT",
      publishMavenStyle := true
    )),
    name := "VectorDisassembler",
    libraryDependencies := Seq(  
    scalaTest % Test,
    "org.apache.spark" %% "spark-core" % "2.2.1",
    "org.apache.spark" %% "spark-sql" % "2.2.1",
    "org.apache.spark" %% "spark-mllib" % "2.2.1",
    "org.apache.hadoop" % "hadoop-hdfs" % "2.7.3"
    )
  )
