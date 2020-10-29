package com.arilab.expman.config.datasources;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;
import java.util.Properties;

    @Configuration
    @EnableTransactionManagement
    @EnableJpaRepositories(basePackages = "com.arilab.expman.repository.arilabdb",
            entityManagerFactoryRef = "arilabdbEntityManagerFactory",
            transactionManagerRef = "arilabdbTransactionManager")
    public class ArilabdbDataSourceConfiguration {


        private final Validator validator;

        public ArilabdbDataSourceConfiguration(@Qualifier("localValidatorFactoryBean") Validator validator) {
            this.validator = validator;
        }


        @Bean
        @Primary
        @ConfigurationProperties("expman.datasource.arilabdb")
        public DataSourceProperties arilabdbDataSourceProperties() {
            return new DataSourceProperties();
        }


        @Bean
        @ConfigurationProperties("expman.datasource.arilabdb.configuration")
        public HikariDataSource arilabdbataSource() {
            return arilabdbDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
        }


        @Bean
        public LocalContainerEntityManagerFactoryBean arilabdbEntityManagerFactory() {
            LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
            factory.setDataSource(arilabdbataSource());
            factory.setPackagesToScan("com.arilab.expman.domain.arilabdb");
            factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

            Properties jpaProperties = new Properties();
            jpaProperties.put("hibernate.hbm2ddl.auto", "validate");
            jpaProperties.put("hibernate.show-sql", "true");
            jpaProperties.put("hibernate.format_sql", "true");
            jpaProperties.put("hibernate.generate_statistics","false");
            jpaProperties.put("javax.persistence.validation.group.pre-persist", "");
            jpaProperties.put("javax.persistence.validation.factory", validator);
            factory.setJpaProperties(jpaProperties);
            return factory;
        }


        @Bean
        public TransactionManager arilabdbTransactionManager(
                @Qualifier("arilabdbEntityManagerFactory") EntityManagerFactory entityManagerFactory){
            JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
            jpaTransactionManager.setDataSource(arilabdbataSource());
            jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
            return jpaTransactionManager;
        }
}
