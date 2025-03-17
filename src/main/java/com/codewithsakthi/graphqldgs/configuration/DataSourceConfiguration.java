package com.codewithsakthi.graphqldgs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.datafaker.Faker;

@Configuration
public class DataSourceConfiguration {

    @Bean
    Faker faker(){
        return new Faker();
    }
    
}
