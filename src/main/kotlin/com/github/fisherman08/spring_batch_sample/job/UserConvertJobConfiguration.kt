package com.github.fisherman08.spring_batch_sample.job

import com.github.fisherman08.spring_batch_sample.domain.ConvertedUser
import com.github.fisherman08.spring_batch_sample.domain.User
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
@EnableBatchProcessing
class UserConvertJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {
    @Bean
    fun getUserConvertJob(): Job =
        jobBuilderFactory
            .get("userConvertJob_${LocalDateTime.now()}")
            .flow(getStep())
            .end()
            .build()

    @Bean
    fun getStep(): Step =
        stepBuilderFactory
            .get("userConvertStep")
            .chunk<User, ConvertedUser>(2)
            .reader(getUserReader())
            .processor(getUserProcessor())
            .writer(getConvertedUserWriter())
            .build()

    @Bean
    fun getUserReader(): ItemReader<User> = UserReader()

    @Bean
    fun getUserProcessor(): ItemProcessor<User, ConvertedUser> = UserConvertProcessor()

    @Bean
    fun getConvertedUserWriter(): ItemWriter<ConvertedUser> = ConvertedUserWriter()
}
