package com.finantial.app.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.ClienteProducto;
import com.finantial.app.models.ClienteProductoDTO;
import com.finantial.app.models.CuentaBancaria;
import com.finantial.app.models.Producto;
import com.finantial.app.repository.IClienteProductoRepository;
import com.finantial.app.repository.IClienteRepository;
import com.finantial.app.repository.IProductoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteProductoServiceImpl implements IClienteProductoService {

	@Autowired
	private IClienteProductoRepository ClienteProductoRepo;
	
	@Autowired
	private IClienteRepository clienteRepo;
	
	@Autowired
	private IProductoRepository productoRepo;
	
	@Autowired
	private ICuentaBancaria cuentaService;
	
	@Override
	public Flux<ClienteProducto> findAll() {
		return ClienteProductoRepo.findAll();
	}
	
	@Override
	public Mono<ClienteProducto> finById(String id) {
		return ClienteProductoRepo.findById(id);
	}

	@Override
	public Mono<ClienteProducto> save(ClienteProducto t) {
		//List<Producto> productos = new ArrayList<>();
		//Mono<Cliente> clienteMono = clienteRepo.findById(t.getCliente().getIdCliente());
		/*
		
		return ClienteProductoRepo.findByCliente(t.getCliente())
		.map(cliente -> {
			System.out.println(cliente.toString());
			return cliente.getProductos();
		}).flatMap(productos ->{
			System.out.println("flatmap");
			t.getProductos().forEach(pro1 -> {
				System.out.println("foreach 1");
				productos.forEach(pro2 -> {
					System.out.println("foreach 2");
					if(pro1.getIdProducto() == pro2.getIdProducto()) {
						flag = true;
					}
				});
			});
			if(flag = true) {
				System.out.println("flag true");
				flag = false;
				return Mono.error(new InterruptedException("No puede asignar mas de una vez el mismo tipo de producto"));
			}
			return ClienteProductoRepo.save(t);
		});
		
		
*/
/*
		return clienteMono
		.defaultIfEmpty(new Cliente())
		.flatMap(c -> {
			if(c.getIdCliente() == null) {
				return Mono.error(new InterruptedException("El cliente no existe"));
			}
			return Mono.just(c);
		}).flatMap(cl -> ClienteProductoRepo.save(t));
		*/
		return null;
	}

		
		/*
		.flatMap(c -> {
			t.setCliente(c);
			for (int i = 0; i < t.getProductos().size(); i++) {
				for (int j = 0; j < t.getProductos().size(); j++) {
					Producto pro = t.getProductos().get(j);
					Mono<Producto> productoMono = productoRepo.findById(pro.getIdProducto());
					productoMono
					.flatMap(p -> {
						System.out.println("FlatMap");
						if(p == null) {
							System.out.println("No existe producto **");
							return Mono.error(new InterruptedException("No existe el producto"));
						}
						if(pro.getIdProducto() == t.getProductos().get(i).getIdProducto()) {
							return Mono.error(new InterruptedException("No existe el producto"));
						}
						return Mono.just(p);
					}).subscribe();
				}
			}
			t.setProductos(productos);
			return ClienteProductoRepo.save(t);
		});
			*/
		
				/*
			t.getProductos().forEach(pro -> {
				Mono<Producto> productoMono = productoRepo.findById(pro.getIdProducto());
				productoMono
				.flatMap(p -> {
					System.out.println("FlatMap");
					if(p == null) {
						System.out.println("No existe producto **");
						return Mono.error(new InterruptedException("No existe el producto"));
					}
					if(t.getProductos().get(contador).getIdProducto()==pro.getIdProducto()) {
						
					}
					if(t.getProductos().get(i).getIdProducto() == pro.getIdProducto()) {
						
					}
					System.out.println(p.toString());
					System.out.println("productosAdd");
					productos.add(p);
					return Mono.just(p);
				}).subscribe();
			});
			}
			t.setProductos(productos);
			return ClienteProductoRepo.save(t);
		});
		*/
		
		/*
		t.getProductos().forEach(p -> {
			
			
			Mono<Producto> productoMono = productoRepo.findById(p.getIdProducto())
			productoMono
			.defaultIfEmpty(new Producto())
			.flatMap(p -> {
				if(p.g== null) {
					return Mono.error(new InterruptedException("El cliente no existe"));
				}
				return Mono.just(c);
			})
			.
			*/
			
		/*	
		});
		for (int i = 0; i < t.getProductos().size(); i++) {
			t.getProductos().forEach(pro -> {
				if(t.getProductos().get(0).getCodigoProducto() == pro.getCodigoProducto()) {
					flag = 1;
				}
			});
		}
		if(flag == 1) {
			flag = 0;
			return Mono.just(new ClienteProducto());
		}
		return ClienteProductoRepo.save(t);
		*/
	

	@Override
	public Mono<Void> delete(ClienteProducto t) {
		return ClienteProductoRepo.delete(t);
	}

	@Override
	public Mono<Void> deleteById(String id) {
		return ClienteProductoRepo.deleteById(id);
	}


	@Override
	public Mono<ClienteProductoDTO> saveClienteProductoDTO(ClienteProductoDTO dto) {
		if(dto.getCliente()!= null && dto.getProductos().size()> 0 && dto.getProductos()!= null) {
			clienteRepo.findById(dto.getCliente().getIdCliente())
			.flatMap(cl->{
				dto.setCliente(cl);
				return Mono.just(cl);
			})
			.subscribe();
			dto.getProductos().forEach(x -> {
				productoRepo.findById(x.getIdProducto())
				.map(p-> {
					ClienteProducto clproducto = new ClienteProducto(dto.getCliente(), p);
					ClienteProductoRepo.save(clproducto).subscribe();
					cuentaService.save(new CuentaBancaria(dto.getCliente())).subscribe();
					return p;
				}).subscribe();
			});
		}
		return this.findByCliente(dto.getCliente());
	}

	@Override
	public Mono<ClienteProductoDTO> findByCliente(Cliente cliente) {
		ClienteProductoDTO dto = new ClienteProductoDTO();
		List<Producto> productos = new ArrayList<>();
		System.out.println("Find");
		return ClienteProductoRepo.findByCliente(cliente)
		.map(clPro -> {
			System.out.println("clPro map: " +clPro);
			dto.setCliente(clPro.getCliente());
			productos.add(clPro.getProducto());
			dto.setProductos(productos);
			System.out.println(dto);
			return clPro;
		})
		.then(Mono.just(dto));
	}

}
