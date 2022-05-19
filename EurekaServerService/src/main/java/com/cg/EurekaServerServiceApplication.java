package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//It make your Spring Boot application acts as a Eureka Server.
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerServiceApplication.class, args);
	}

}
