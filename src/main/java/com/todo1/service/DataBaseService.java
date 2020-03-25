package com.todo1.service;

import java.sql.DriverManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.todo1.exception.Excepcion;

@Service
public class DataBaseService {
	Logger LOG = LoggerFactory.getLogger(MovimientoService.class);

	@Value("${spring.datasource.driver-class-name}")
	private String clase;

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.password}")
	private String pass;

	@Value("${spring.datasource.username}")
	private String user;

	/**
	 * Método que permite validar la conexión con la base de datos
	 */
	public void validarAccesoDataBase() {
		try {
			Class.forName(clase);
			DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			LOG.error("No existe conexión con la base de datos.");
			throw new Excepcion(DataBaseService.class.getName() + "-SIN_CONEXION");
		}
	}
}
