package com.microserviceTP.sv_eurika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SvEurikaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvEurikaApplication.class, args);
	}

}
