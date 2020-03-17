package com.todo1.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo1.exception.Excepcion;
import com.todo1.model.Origen;
import com.todo1.repo.IOrigenRepo;


@Service
public class OrigenService {
	@Autowired
	private IOrigenRepo repo;

	Logger log = LoggerFactory.getLogger(OrigenService.class);

	/**
	 * Método que permite crear origen
	 * 
	 * @param org
	 * @return Origen
	 */
	public Origen crear(Origen org) {
		if (existe(org.getDescripcion())) {
			log.error("El origen ya existe");
			throw new Excepcion(OrigenService.class.getName() + "-CREAR_YA_EXISTE");
		}
		return repo.save(org);
	}

	/**
	 * Validar por la descripcion si existe un origen
	 * 
	 * @param descripcion
	 * @return boolean
	 */
	private boolean existe(String descripcion) {
		return repo.findAll().stream().anyMatch(t -> t.getDescripcion().equals(descripcion));
	}

	/**
	 * Método que permite listar todos los origen
	 * 
	 * @return List<Origen>
	 */
	public List<Origen> listar() {
		return repo.findAll();
	}

	/**
	 * Método que permite modificar un origen
	 * 
	 * @param org
	 * @return Origen
	 */
	public Origen modificar(Origen org) {
		if (existe(org.getDescripcion())) {
			log.error("El origen ya existe");
			throw new Excepcion(OrigenService.class.getCanonicalName() + "-MODIFICAR_YA_EXISTE");
		}
		return repo.save(org);
	}

	/**
	 * Método que permite eliminar un origen
	 * 
	 * @param org
	 */
	public void eliminar(Origen org) {
		if (!existe(org.getDescripcion())) {
			log.error("El origen no existe");
			throw new Excepcion(OrigenService.class.getName() + "-ELIMINAR_NO_EXISTE");
		}
		repo.deleteById(org.getIdOrigen());
	}

}
