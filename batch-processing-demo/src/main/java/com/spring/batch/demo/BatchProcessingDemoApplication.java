package com.spring.batch.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.spring.batch.demo.*","com.spring.batch.demo.*.*"})
public class BatchProcessingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchProcessingDemoApplication.class, args);
	}

}
