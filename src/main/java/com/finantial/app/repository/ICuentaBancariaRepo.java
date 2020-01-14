package com.finantial.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.CuentaBancaria;

import reactor.core.publisher.Flux;
@Repository
public interface ICuentaBancariaRepo extends ReactiveMongoRepository<CuentaBancaria, String>{
	Flux<CuentaBancaria> findByCliente(Cliente cliente);
}
