package com.finantial.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.finantial.app.models.Cliente;
@Repository
public interface IClienteRepository extends ReactiveMongoRepository<Cliente, String>{

}
