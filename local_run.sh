#!/usr/bin/env bash

# after ./gradlew clean build

spark-submit --class org.miejski.kotlinspark.MainAppKt  --master "local[4]" build/libs/kotlinspark.jar