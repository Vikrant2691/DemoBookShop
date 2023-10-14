package com.demo.bookshop.DemoBookShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoBookShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBookShopApplication.class, args);
	}

}
