package com.arilab.expman.config.datasources;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
public class AppDataSourceConfiguration {


    @Bean
    @Primary
    @ConfigurationProperties("expman.datasource.app")
    public HikariDataSource expmanDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }


}
