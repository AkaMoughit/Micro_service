package com.microserviceTP.car;

import com.microserviceTP.car.entities.Car;
import com.microserviceTP.car.repositories.CarRepository;
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
	CommandLineRunner initializeMysqlDatabase(CarRepository carRepository){
		return args -> {
			carRepository.save(new Car(Long.parseLong("1"),"Nissan","Nissan","Nissan",Long.parseLong("1")));
			carRepository.save(new Car(Long.parseLong("2"),"Audi","Audi","Audi",Long.parseLong("2")));
			carRepository.save(new Car(Long.parseLong("3"),"Mercedes","Mercedes","Mercedes",Long.parseLong("3")));
			carRepository.save(new Car(Long.parseLong("4"),"DACIA","DACIA","DACIA",Long.parseLong("4")));
		};
	}
}
