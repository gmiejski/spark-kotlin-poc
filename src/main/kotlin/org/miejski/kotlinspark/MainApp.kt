package org.miejski.kotlinspark

import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

fun main(args: Array<String>) {
    println("Hello, world!")

    val conf = SparkConf().setAppName("kotlinYarnTest")
    val sc = JavaSparkContext(conf)

    val rdd = sc.parallelize(listOf(14, 2, 5, 6, 125, 647, 423))
    val filtered = rdd.map { it * 4 }
            .filter { m -> m % 6 == 0 }
    filtered.foreach { println(it) }
    rdd.saveAsTextFile("/projects/profile_test/main/end2endtest/grzegorz.miejski/kotlin/")

}

