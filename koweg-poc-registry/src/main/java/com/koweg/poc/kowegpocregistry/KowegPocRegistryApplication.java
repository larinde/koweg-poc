package com.koweg.poc.kowegpocregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KowegPocRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(KowegPocRegistryApplication.class, args);
	}

}
