package com.finantial.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.finantial.app.models.Producto;
@Repository
public interface IProductoRepository extends ReactiveMongoRepository<Producto, String>{

}
