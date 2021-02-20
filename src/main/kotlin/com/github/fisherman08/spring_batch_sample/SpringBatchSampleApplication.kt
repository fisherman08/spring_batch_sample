package com.github.fisherman08.spring_batch_sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBatchSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringBatchSampleApplication>(*args)
}
