package com.microserviceTP.client;

import com.microserviceTP.client.entities.Client;
import com.microserviceTP.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}


	@Bean
	CommandLineRunner initializeMysqlDatabase(ClientRepository clientRepository){
		return args -> {
			clientRepository.save(new Client(Long.parseLong("1"),"amine1",Float.parseFloat("26")));
			clientRepository.save(new Client(Long.parseLong("2"),"khalid",Float.parseFloat("26")));
			clientRepository.save(new Client(Long.parseLong("3"),"mouad",Float.parseFloat("23")));
			clientRepository.save(new Client(Long.parseLong("4"),"nouh",Float.parseFloat("21")));
		};
	}
}
