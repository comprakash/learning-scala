import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.SQLContext
import org.apache.spark.ml.feature.NGram

/**
  * Created by Om Prakash on 7/5/2017.
  */
object NGramExample extends App{

  val conf = new SparkConf().setAppName("temp-project").setMaster("local[2]")

  val sc = new SparkContext(conf)

  val sqlContext = new SQLContext(sc)

  val wordDataFrame = sqlContext.createDataFrame(Seq( (0, Array("Hi", "I", "want", "to", "learn", "data", "science")), (1, Array("I", "want", "to", "use", "Scala")), (2, Array("This", "is", "easy", "and", "fun")) )).toDF("label", "words")

  val ngram = new NGram().setInputCol("words").setOutputCol("ngrams")

  val ngramDataFrame = ngram.transform(wordDataFrame)

  ngramDataFrame.take(3).map(line => line.getAs[Stream[String]]("ngrams").toList).foreach(println)
}
