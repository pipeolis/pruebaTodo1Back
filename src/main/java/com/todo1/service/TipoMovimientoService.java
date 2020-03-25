package com.todo1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.exception.Excepcion;
import com.todo1.model.TipoMovimiento;
import com.todo1.repo.ITipoMovimientoRepo;

@Service
public class TipoMovimientoService {
	@Autowired
	private ITipoMovimientoRepo repo;

	Logger log = LoggerFactory.getLogger(TipoMovimientoService.class);

	/**
	 * Método que permite crear tipos de movimiento
	 * 
	 * @param tmov
	 * @return TipoMovimiento
	 */
	public TipoMovimiento crear(TipoMovimiento tmov) {
		if (existe(tmov.getDescripcion())) {
			log.error("El tipo movimiento ya existe");
			throw new Excepcion(TipoMovimientoService.class.getName() + "-CREAR_YA_EXISTE");
		}
		return repo.save(tmov);
	}

	/**
	 * Validar por la descripcion si existe un tipo de movimiento
	 * 
	 * @param descripcion
	 * @return boolean
	 */
	private boolean existe(String descripcion) {
		return repo.findAll().stream().anyMatch(t -> t.getDescripcion().equals(descripcion));
	}

	/**
	 * Método que permite listar todos los tipos de movimiento
	 * 
	 * @return List<TipoMovimiento>
	 */
	public List<TipoMovimiento> listar() {
		return repo.findAll();
	}

	/**
	 * Método que permite modificar un tipo de movimiento
	 * 
	 * @param tmov
	 * @return TipoMovimiento
	 */
	public TipoMovimiento modificar(TipoMovimiento tmov) {
		if (existe(tmov.getDescripcion())) {
			log.error("El tipo movimiento ya existe");
			throw new Excepcion(TipoMovimientoService.class.getCanonicalName() + "-MODIFICAR_YA_EXISTE");
		}
		return repo.save(tmov);
	}

	/**
	 * Método que permite eliminar un tipo de movimiento
	 * 
	 * @param tmov
	 */
	public boolean eliminar(TipoMovimiento tmov) {
		if (!existe(tmov.getDescripcion())) {
			log.error("El tipo movimiento no existe");
			throw new Excepcion(TipoMovimientoService.class.getName() + "-ELIMINAR_NO_EXISTE");
		}
		repo.deleteById(tmov.getIdTipoMovmiento());
		return true;
	}

}
