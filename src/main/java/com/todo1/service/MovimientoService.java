package com.todo1.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.exception.Excepcion;
import com.todo1.model.Movimiento;
import com.todo1.repo.IMovimientoRepo;
import com.todo1.rest.MovimientoRestController;

@Service
public class MovimientoService {
	@Autowired
	private IMovimientoRepo repoMov;
	@Autowired
	private ProductoService pserv;

	Logger log = LoggerFactory.getLogger(MovimientoService.class);

	/**
	 * Método que permite crear un movimiento
	 * 
	 * @param mov
	 * @return
	 */
	public Movimiento crear(Movimiento mov) {
		
		if(!pserv.existeProductoById(mov.getIdProducto())) {
			log.error("No existe producto");
			throw new Excepcion(MovimientoRestController.class.getName() + "-PRODUCTO_NO_EXISTE");
		}
		
		if (mov.getIdTipoMovimiento() == 1) {// VENTA
			if (mov.getCantidad() > stockProducto(mov.getIdProducto())) {
				log.error("La cantidad del producto supera el stock");
				throw new Excepcion(MovimientoService.class.getName() + "-SUPERA_STOCK");
			}

		}

		if (!validarPositivo(mov)) {
			log.error("La cantidad o valor unitario de producto son menores o iguales a cero. Verifique");
			throw new Excepcion(MovimientoService.class.getName() + "-CANT_VALOR_MENOR_IGUAL_CERO");
		}		

		if (mov.getIdTipoMovimiento() == 1) {// VENTA
			mov.setCantidad(mov.getCantidad() * (-1));
			mov.setValorUnitario(mov.getValorUnitario() * (-1));
			mov.setValorTotal(mov.getValorTotal() * (-1));
		}		
		
		mov.setFecMovimiento(new Date());
		return repoMov.save(mov);
	}

	/**
	 * Método que permite obtener el stock de un producto
	 * 
	 * @param idProd
	 * @return int
	 */
	public int stockProducto(int idProd) {
		return repoMov.findAll().stream().filter(m -> m.getIdProducto() == idProd).mapToInt(Movimiento::getCantidad)
				.sum();
	}

	/**
	 * Método que permite validar si la cantidad o valor unitario son menores o
	 * iguales a cero
	 * 
	 * @param mov
	 * @return boolean
	 */
	private boolean validarPositivo(Movimiento mov) {
		if (mov.getCantidad() <= 0 || mov.getValorUnitario() <= 0) {
			return false;
		}
		return true;
	}
		
	/**
	 * Método que permite listar todos los movimiento
	 * 
	 * @return List<Movimiento>
	 */
	public List<Movimiento> listar(){
		return repoMov.findAll();
	}
	
	
}
