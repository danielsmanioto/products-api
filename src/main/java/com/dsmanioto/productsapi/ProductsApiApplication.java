package com.dsmanioto.productsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@SpringBootApplication
public class ProductsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsApiApplication.class, args);
	}

}
