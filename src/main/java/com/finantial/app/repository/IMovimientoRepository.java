package com.finantial.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.Movimiento;

import reactor.core.publisher.Flux;

@Repository
public interface IMovimientoRepository extends ReactiveMongoRepository<Movimiento, String>{
	Flux<Movimiento> findByCliente(Cliente cliente);
}
