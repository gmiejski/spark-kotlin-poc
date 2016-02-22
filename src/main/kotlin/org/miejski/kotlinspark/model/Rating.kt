package org.miejski.kotlinspark.model

import java.io.Serializable

data class Rating(val userId: String, val movieId: String, val rating: String): Serializable {
    companion object Factory {
        fun create(row: List<String>): Rating {
            return Rating(row[0], row[1], row[2])
        }
    }
}
