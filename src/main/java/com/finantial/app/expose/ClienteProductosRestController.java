package com.finantial.app.expose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finantial.app.business.IClienteProductoService;
import com.finantial.app.models.ClienteProductoDTO;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clientesProductos")
public class ClienteProductosRestController {
	@Autowired
	private IClienteProductoService clienteProductosService;
	
	@GetMapping
	public Mono<ClienteProductoDTO> listarProductoxCliente(ClienteProductoDTO dto) {
		return clienteProductosService.findByCliente(dto.getCliente());
	}
	
	@PostMapping
	public Mono<ClienteProductoDTO> registrarCliente(@RequestBody ClienteProductoDTO clienteProductoDTO) {
		return clienteProductosService.saveClienteProductoDTO(clienteProductoDTO);
	}
	/*
	@Autowired
	private IClienteProductosService clienteProductosService;

	@GetMapping
	public Flux<ClienteProductos> listarAllClientes() {
		return clienteProductosService.findAll();
	}

	@GetMapping("/{id}")
	public Mono<ClienteProductos> buscarCliente(@PathVariable String id) {
		return clienteProductosService.finById(id);
	}

	@PostMapping
	public Mono<ClienteProductos> registrarCliente(@RequestBody ClienteProductos clienteProductos) {
		return clienteProductosService.save(clienteProductos);
	}

	@PutMapping
	public Mono<ClienteProductos> actualizarCliente(@RequestBody ClienteProductos clienteProductos) {
		return clienteProductosService.save(clienteProductos);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> eliminarCliente(@PathVariable String id){
		return clienteProductosService.deleteById(id);
	}
	*/
}
