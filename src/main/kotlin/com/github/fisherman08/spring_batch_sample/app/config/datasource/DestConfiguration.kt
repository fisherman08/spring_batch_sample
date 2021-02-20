package com.github.fisherman08.spring_batch_sample.app.config.datasource

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.classify.annotation.Classifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import javax.sql.DataSource

@Component
@ConfigurationProperties(prefix = "spring.datasource.dest")
class DestConfiguration {
    lateinit var url: String
    lateinit var username: String
    lateinit var password: String

    @Bean(name = ["dest"])
    fun dateSource(): DataSource =
        DataSourceBuilder
            .create()
            .url(url)
            .username(username)
            .password(password)
            .build()
}
