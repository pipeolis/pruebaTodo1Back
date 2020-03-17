package com.todo1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.exception.Excepcion;
import com.todo1.model.TipoProducto;
import com.todo1.repo.ITipoProductoRepo;

@Service
public class TipoProductoService {
	@Autowired
	private ITipoProductoRepo repo;

	Logger log = LoggerFactory.getLogger(TipoProductoService.class);

	/**
	 * Método que permite crear tipos de producto
	 * 
	 * @param tprod
	 * @return TipoProducto
	 */
	public TipoProducto crear(TipoProducto tprod) {
		if (existe(tprod.getDescripcion())) {
			log.error("El tipo producto ya existe");
			throw new Excepcion(TipoProductoService.class.getName() + "-CREAR_YA_EXISTE");
		}
		return repo.save(tprod);
	}

	/**
	 * Validar por la descripcion si existe un tipo de producto
	 * 
	 * @param descripcion
	 * @return boolean
	 */
	private boolean existe(String descripcion) {
		return repo.findAll().stream().anyMatch(t -> t.getDescripcion().equals(descripcion));
	}

	/**
	 * Método que permite listar todos los tipos de producto
	 * 
	 * @return List<TipoProducto>
	 */
	public List<TipoProducto> listar() {
		return repo.findAll();
	}

	/**
	 * Método que permite modificar un tipo de producto
	 * 
	 * @param tprod
	 * @return TipoProducto
	 */
	public TipoProducto modificar(TipoProducto tprod) {
		if (existe(tprod.getDescripcion())) {
			log.error("El tipo producto ya existe");
			throw new Excepcion(TipoProductoService.class.getCanonicalName() + "-MODIFICAR_YA_EXISTE");
		}
		return repo.save(tprod);
	}

	/**
	 * Método que permite eliminar un tipo de producto
	 * 
	 * @param tprod
	 */
	public void eliminar(TipoProducto tprod) {
		if (!existe(tprod.getDescripcion())) {
			log.error("El tipo producto no existe");
			throw new Excepcion(TipoProductoService.class.getName() + "-ELIMINAR_NO_EXISTE");
		}
		repo.deleteById(tprod.getIdTipoProducto());
	}

}
