package com.example.shareddrawingboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class SharedDrawingBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedDrawingBoardApplication.class, args);
	}
}
