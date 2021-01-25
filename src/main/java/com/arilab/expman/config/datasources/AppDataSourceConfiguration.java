package com.arilab.expman.config.datasources;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
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
@EnableJpaRepositories(basePackages = "com.arilab.expman.repository.app",
        entityManagerFactoryRef = "expmanEntityManagerFactory",
        transactionManagerRef = "expmanTransactionManager")
public class AppDataSourceConfiguration {


    private final Validator validator;

    public AppDataSourceConfiguration(@Qualifier("localValidatorFactoryBean") Validator validator) {
        this.validator = validator;
    }


    @Autowired
    private Environment env;

    @Bean
    @ConfigurationProperties("expman.datasource.app")
    public DataSourceProperties expmanDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean
    @ConfigurationProperties("expman.datasource.app.configuration")
    public HikariDataSource expmanDataSource() {
        return expmanDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean expmanEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(expmanDataSource());
        factory.setPackagesToScan("com.arilab.expman.domain.app");
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        jpaProperties.put("hibernate.show-sql", "true");
        jpaProperties.put("hibernate.format_sql", "true");
        jpaProperties.put("hibernate.generate_statistics","false");
        jpaProperties.put("javax.persistence.validation.group.pre-persist", "com.arilab.expman.domain.app.validator.OnInsert");
        jpaProperties.put("javax.persistence.validation.factory", validator);
        factory.setJpaProperties(jpaProperties);
        return factory;
    }


    @Bean
    public TransactionManager expmanTransactionManager(@Qualifier("expmanEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setDataSource(expmanDataSource());
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }


}
