package com.example.demo_spring_security.common.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@ConfigurationProperties(prefix = "application-config")
@JsonIgnoreProperties(value = {"$$beanFactory"})
@Setter
@Getter
public class ApplicationConfiguration {
    private HashMap<String,String> security;
}
