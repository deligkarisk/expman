package com.arilab.expman;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ExpmanApplication {

    private static ApplicationContext applicationContext;

    public static void main(String[] args) {

        applicationContext = SpringApplication.run(ExpmanApplication.class, args);
        displayBeans();
    }

    public static void displayBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(allBeanNames);
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }



}
