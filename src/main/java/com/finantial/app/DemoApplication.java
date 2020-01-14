package com.finantial.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

import com.finantial.app.models.Cliente;
import com.finantial.app.models.ClienteProducto;
import com.finantial.app.models.CuentaBancaria;
import com.finantial.app.models.Producto;
import com.finantial.app.models.TipoCliente;
import com.finantial.app.models.TipoProducto;
import com.finantial.app.repository.IClienteRepository;
import com.finantial.app.repository.IProductoRepository;
import com.finantial.app.repository.ITipoClienteRepository;
import com.finantial.app.repository.ITipoProductoRepository;

import reactor.core.publisher.Flux;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private IClienteRepository clienteRepo;
	@Autowired
	private ITipoClienteRepository tipoClienteRepo;
	
	@Autowired
	private IProductoRepository productoRepo;
	@Autowired
	private ITipoProductoRepository tipoProductoRepo;

	@Autowired
	private ReactiveMongoTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(Cliente.class).subscribe();
		template.dropCollection(TipoCliente.class).subscribe();
		template.dropCollection(Producto.class).subscribe();
		template.dropCollection(TipoProducto.class).subscribe();
		template.dropCollection(ClienteProducto.class).subscribe();
		template.dropCollection(CuentaBancaria.class).subscribe();
		
		// REGISTRO DE TIPO DE CLIENTSE Y CLIENTES
		TipoCliente tip1 = new TipoCliente("Empresarial");
		TipoCliente tip2 = new TipoCliente("Peronal");

		TipoProducto tipP1 = new TipoProducto("Cuentas Bancarias");
		TipoProducto tipP2 = new TipoProducto("Creditos");

		Flux.just(tip1, tip2)
		.flatMap(tip -> tipoClienteRepo.save(tip)).
		thenMany(
				Flux.just(new Cliente("Jose Luis", "Cayo", "Acuña", "74642154", tip1), 
						new Cliente("Juan", "Perez", "Aguinaldo", "73242154", tip2),
						new Cliente("Alfonzo", "Gilberto", "Orio", "11232154", tip2)
						)
				.flatMap(cli -> clienteRepo.save(cli))
			)
		.subscribe(res -> System.out.println("Cliente".concat(res.toString().concat(" " + "Registrado"))));
		
		
		// REGISTRO DE TIPO DE PRODUCTOS Y PRODUCTOS
		Flux.just(tipP1, tipP2)
		.flatMap(tipP -> tipoProductoRepo.save(tipP))
		.thenMany(
				Flux.just(new Producto("Ahorro", tipP1, 1),
						new Producto("Cuenta Corriente", tipP1, 2),
						new Producto("Cuenta a Plazo Fijo", tipP1,3),
						new Producto("Personal", tipP2, 4),
						new Producto("Empresarial", tipP2, 5),
						new Producto("Tarjeta de Credito", tipP2, 6),
						new Producto("Adelanto Efectivo", tipP2, 7)
						)
				).flatMap(pro -> productoRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
	}

}
