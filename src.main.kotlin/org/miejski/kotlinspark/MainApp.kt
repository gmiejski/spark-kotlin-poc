package org.miejski.kotlinspark

import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext

fun main(args: Array<String>) {
    println("Hello, world!")

    val conf = SparkConf().setAppName("simpleApp").setMaster("local[2]")
    val sc = JavaSparkContext(conf)

    val rdd = sc.parallelize(listOf(14, 2, 5, 6, 125, 647, 423))
    rdd.map { it * 3 }
            .filter { m -> m % 6 == 0 }
            .foreach { println(it) }
}

