package com.todo.springboot.todomanagementspringboot.configuration;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class FlywayConfiguration {
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Bean(name = "flyway")
    @ConfigurationProperties(prefix = "test.flyway")
    public FlywayProperties getFlywayProperties() {
        return new FlywayProperties();
    }

    @Bean
    DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dataSourceProperties.getDriverClassName());
        dataSourceBuilder.url(dataSourceProperties.getUrl());
        dataSourceBuilder.username(dataSourceProperties.getUsername());
        dataSourceBuilder.password(dataSourceProperties.getPassword());
        return dataSourceBuilder.build();
    }

    public void migrate() {
        ClassicConfiguration classicConfiguration = new ClassicConfiguration();
        classicConfiguration.setLocationsAsStrings(Arrays.stream(getFlywayProperties().getLocations().toArray()).toArray(String[]::new));
        classicConfiguration.setDataSource(dataSource());
        classicConfiguration.setBaselineOnMigrate(true);
        Flyway flyway = new Flyway(classicConfiguration);
        flyway.migrate();
    }
}
