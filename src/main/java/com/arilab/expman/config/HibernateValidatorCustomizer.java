package com.arilab.expman.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

import javax.validation.ValidatorFactory;
import java.util.Map;


@Component
public class HibernateValidatorCustomizer implements HibernatePropertiesCustomizer {

    @Autowired
    private ValidatorFactory validatorFactory;

    public void customize(Map<String, Object> hibernateProperties) {
        if (validatorFactory != null) {
            hibernateProperties.put("javax.persistence.validation.factory", validatorFactory);
        }
    }
}








