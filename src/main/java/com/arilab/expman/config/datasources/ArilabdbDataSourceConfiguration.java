package com.arilab.expman.config.datasources;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class ArilabdbDataSourceConfiguration {

  //  @Bean
    //@ConfigurationProperties("expman.datasource.arilabdb")
    public HikariDataSource arilabdbDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
