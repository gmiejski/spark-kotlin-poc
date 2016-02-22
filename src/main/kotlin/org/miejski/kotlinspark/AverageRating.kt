package org.miejski.kotlinspark

import org.apache.spark.api.java.JavaRDD
import org.miejski.kotlinspark.model.Rating
import scala.Tuple2
import java.io.Serializable

class AverageRating : Serializable {
    fun count(x: JavaRDD<Rating>): List<Tuple2<String, Int>> {
        return x.mapToPair { Tuple2(it.rating, 1) }
                .reduceByKey { i, j -> i + j }
                .collect()
    }
}