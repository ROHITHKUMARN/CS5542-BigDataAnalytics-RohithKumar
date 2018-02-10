import org.apache.spark.mllib.evaluation.{MulticlassMetrics}
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by VenkatNag on 2/8/2018.
  */
object icp4 {

  def main(args:Array[String])
  {
    System.setProperty("hadoop.home.dir", "E:\\UMKC\\Sum_May\\KDM\\winutils")
    val conf = new SparkConf().setAppName(s"KMeansExample with ").setMaster("local[*]").set("spark.driver.memory", "4g").set("spark.executor.memory", "4g")
    val sc = new SparkContext(conf)
    val sql=new SQLContext(sc)
    val predictionLabels: RDD[(Double, Double)]=sc.parallelize(Seq((1.0,1.0),(0.0,1.0),(0.0,0.0),(0.0,1.0),(1.0,0.0),(0.0,0.0),(0.0,0.0),(1.0,1.0),(0.0,1.0),(0.0,0.0)))
    val metrics = new MulticlassMetrics(predictionLabels)
    val confusion= metrics.confusionMatrix
    println(s"confusion Matrix")
    println(confusion)
    val accuracy = predictionLabels.filter(r => r._1 == r._2).count.toDouble / predictionLabels.count()
    println(s"Accuracy = $accuracy")
    val error=1-accuracy
    println(s"Error rate=$error")
    println(s"Weighted True positive rate: ${metrics.weightedTruePositiveRate}")
    println(s"Weighted false positive rate: ${metrics.weightedFalsePositiveRate}")
    val specificity=1-metrics.weightedFalsePositiveRate
    println(s"specificity=$specificity")
    println(s"Weighted precision: ${metrics.weightedPrecision}")
    println(s"Weighted recall: ${metrics.weightedRecall}")
    val prevalance=(confusion(0,0)+confusion(0,1))/predictionLabels.count()
    println(s"Prevalance=$prevalance")

  }

}

/*
confusion Matrix
4.0  1.0
3.0  2.0
Accuracy = 0.6
Error rate=0.4
Weighted True positive rate: 0.6000000000000001
Weighted false positive rate: 0.4
specificity=0.6
Weighted precision: 0.6190476190476191
Weighted recall: 0.6000000000000001
Prevalance=0.5

 */