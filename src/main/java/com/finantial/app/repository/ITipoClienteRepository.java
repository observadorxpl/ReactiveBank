package com.finantial.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.finantial.app.models.TipoCliente;

@Repository
public interface ITipoClienteRepository extends ReactiveMongoRepository<TipoCliente, String> {

}
