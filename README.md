# Vector Disassembler
 
The Vector Disassembler is a class for [Apache Spark](http://spark.apache.org) which takes a DataFrame Vector data type column as input, and creates a new column in the DataFrame for each item in the Vector.
 
## Usage:
 
```
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
 
val dataset = spark.createDataFrame(
    Seq((0, 1.2, 1.3), (1, 2.2, 2.3), (2, 3.2, 3.3))
    ).toDF("id", "val1", "val2")
 
val assembler = new VectorAssembler()
    .setInputCols(Array("val1", "val2"))
    .setOutputCol("vectorCol")
 
val output = assembler.transform(dataset)
 
output.show()
+---+----+----+---------+
| id|val1|val2|vectorCol|
+---+----+----+---------+
| 0| 1.2| 1.3|[1.2,1.3]|
| 1| 2.2| 2.3|[2.2,2.3]|
| 2| 3.2| 3.3|[3.2,3.3]|
+---+----+----+---------+
 
val disassembler = new org.apache.spark.ml.feature.VectorDisassembler()
    .setInputCol("vectorCol")
 
disassembler.transform(output).show()
+---+----+----+---------+----+----+
| id|val1|val2|vectorCol|val1|val2|
+---+----+----+---------+----+----+
| 0| 1.2| 1.3|[1.2,1.3]| 1.2| 1.3|
| 1| 2.2| 2.3|[2.2,2.3]| 2.2| 2.3|
| 2| 3.2| 3.3|[3.2,3.3]| 3.2| 3.3|
+---+----+----+---------+----+----+
```