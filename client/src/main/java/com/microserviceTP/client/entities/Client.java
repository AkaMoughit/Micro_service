package com.microserviceTP.client.entities;

//all client url : http://localhost:8081/clients
// client by id  urlhttp  ://localhost:8081/clients/id
//all client Gateway url :http://localhost:8888/SERVICE-CLIENT/clients/
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private Float age;

}
