package org.miejski.kotlinspark

import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext
import org.miejski.kotlinspark.model.Rating

fun main(args: Array<String>) {

    val conf = SparkConf().setAppName("kotlinYarnTest")
    val sc = JavaSparkContext(conf)

    val rdd = sc.parallelize(listOf(14, 2, 5, 6, 125, 647, 423))
    val filtered = rdd.map { it * 4 }
            .filter { m -> m % 6 == 0 }
    filtered.foreach { println(it) }

    val userRdd = sc.textFile("/projects/profile_test/main/end2endtest/grzegorz.miejski/kotlin/ratings.dat")
            .map { Rating.create(it.split("::")) }

    AverageRating().count(userRdd).forEach { println(it) }
}

