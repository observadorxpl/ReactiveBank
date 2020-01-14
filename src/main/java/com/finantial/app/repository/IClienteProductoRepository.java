package com.finantial.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.ClienteProducto;

import reactor.core.publisher.Flux;
@Repository
public interface IClienteProductoRepository extends ReactiveMongoRepository<ClienteProducto, String>{
	public Flux<ClienteProducto> findByCliente(Cliente cliente);
}
