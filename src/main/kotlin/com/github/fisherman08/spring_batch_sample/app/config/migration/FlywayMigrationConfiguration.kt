package com.github.fisherman08.spring_batch_sample.app.config.migration

import org.flywaydb.core.Flyway
import org.flywaydb.core.api.MigrationVersion
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct
import javax.sql.DataSource

@Configuration
class FlywayMigrationConfiguration(
    @Qualifier("dest")
    private val destDataSource: DataSource
) {

    @PostConstruct
    fun migrateFlyWay() {
        Flyway
            .configure()
            .dataSource(destDataSource)
            .locations("db.migration.dest")
            .target(MigrationVersion.LATEST)
            .load()
            .migrate()

    }
}
