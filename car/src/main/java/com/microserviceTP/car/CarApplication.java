package com.microserviceTP.car;

import com.microserviceTP.car.entities.Car;
import com.microserviceTP.car.entities.Client;
import com.microserviceTP.car.repositories.CarRepository;
import com.microserviceTP.car.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory= new
				SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(50000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);

		return  restTemplate;
	}
	@Bean
	CommandLineRunner initializeMysqlDatabase(CarRepository carRepository, ClientRepository clientRepository, RestTemplate restTemplate) {
		return args -> {
			// Save clients
			Client clients = clientRepository.save(new Client(Long.parseLong("1"),"Abdelmoughit Moubarik",Float.parseFloat("23")));

			// Save cars with associated clients
			carRepository.save(new Car(1L, "Nissan", "Nissan", "Nissan", clients));
			carRepository.save(new Car(2L, "Audi", "Audi", "Audi", clients));
		};
	}
}
