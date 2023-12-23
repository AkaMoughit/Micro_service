package com.microserviceTP.car.repositories;

import com.microserviceTP.car.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
