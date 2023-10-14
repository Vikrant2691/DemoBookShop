package com.demo.bookshop.DemoBookShop.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service")
public class ServiceProperties {

    private String greeting;


    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
