package com.finantial.app.business;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.ClienteProducto;
import com.finantial.app.models.ClienteProductoDTO;

import reactor.core.publisher.Mono;

public interface IClienteProductoService extends ICRUD<ClienteProducto>{
	public Mono<ClienteProductoDTO> saveClienteProductoDTO(ClienteProductoDTO dto);
	
	public Mono<ClienteProductoDTO> findByCliente(Cliente cliente);
}
