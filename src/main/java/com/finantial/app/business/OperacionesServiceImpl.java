package com.finantial.app.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finantial.app.models.CuentaBancaria;
import com.finantial.app.models.Movimiento;
import com.finantial.app.models.OperacionBancariaDTO;
import com.finantial.app.repository.ICuentaBancariaRepo;
import reactor.core.publisher.Mono;

@Service
public class OperacionesServiceImpl implements IOperacionesService{

	@Autowired
	private ICuentaBancariaRepo cuentaRepo;
	
	@Autowired 
	private IMovimientoService movimientoService;
	
	@Override
	public Mono<CuentaBancaria> retiro(OperacionBancariaDTO dto) {
		return cuentaRepo.findById(dto.getCuentaBancaria().getIdCuentaFinanciera())
		.flatMap(c -> {
			Movimiento mov = new Movimiento(c, dto.getMonto(), "Retiro", new Date());
			if(c.getSaldo() > dto.getMonto()) {
				c.setSaldo(c.getSaldo()-dto.getMonto());
				movimientoService.save(mov).subscribe();
				 return cuentaRepo.save(c);
			}
			return Mono.error(new InterruptedException("No tiene el saldo suficiente para retirar"));
		});
	}

	@Override
	public Mono<CuentaBancaria> deposito(OperacionBancariaDTO dto) {
		return cuentaRepo.findById(dto.getCuentaBancaria().getIdCuentaFinanciera())
				.flatMap(c -> {
					Movimiento mov = new Movimiento(c, dto.getMonto(), "Deposito", new Date());
					c.setSaldo(c.getSaldo() + dto.getMonto());
					movimientoService.save(mov).subscribe();
					return cuentaRepo.save(c);
				});
	}

}
