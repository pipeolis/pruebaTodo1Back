package com.todo1.service;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.todo1.model.Error;
import com.todo1.rest.MovimientoRestController;

@ControllerAdvice
public class ErrorService extends ResponseEntityExceptionHandler {

	private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

	public ErrorService() {
		CODIGOS_ESTADO.put(TipoProductoService.class.getName() + "-ELIMINAR_NO_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(TipoProductoService.class.getName() + "-CREAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(TipoProductoService.class.getName() + "-MODIFICAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409

		CODIGOS_ESTADO.put(TipoMovimientoService.class.getName() + "-ELIMINAR_NO_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(TipoMovimientoService.class.getName() + "-CREAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(TipoMovimientoService.class.getName() + "-MODIFICAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409

		CODIGOS_ESTADO.put(OrigenService.class.getName() + "-ELIMINAR_NO_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(OrigenService.class.getName() + "-CREAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(OrigenService.class.getName() + "-MODIFICAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409

		CODIGOS_ESTADO.put(ProductoService.class.getName() + "-ELIMINAR_NO_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(ProductoService.class.getName() + "-CREAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(ProductoService.class.getName() + "-MODIFICAR_YA_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(ProductoService.class.getName() + "-TIPO_PRODUCTO_NO_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(ProductoService.class.getName() + "-ORIGEN_NO_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(MovimientoRestController.class.getName() + "-PRODUCTO_NO_EXISTE", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(MovimientoService.class.getName() + "-SUPERA_STOCK", HttpStatus.CONFLICT.value()); // 409
		CODIGOS_ESTADO.put(MovimientoService.class.getName() + "-CANT_VALOR_MENOR_IGUAL_CERO", HttpStatus.CONFLICT.value()); // 409
		

	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
		String[] excep = exception.getMessage().split("-");

		String clase = excep[0];
		String mensaje = msgeError(excep[1]);
		Integer codigo = CODIGOS_ESTADO.get(exception.getMessage());

		if (codigo != null) {
			return new ResponseEntity<Error>(new Error(clase, mensaje), HttpStatus.valueOf(codigo));
		}
		return new ResponseEntity<>(new Error(clase, mensaje), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private String msgeError(String constante) {
		String mensaje;
		switch (constante) {
		case "CREAR_YA_EXISTE":
			mensaje = "El registro ya existe";
			break;

		case "MODIFICAR_YA_EXISTE":
			mensaje = "El registro ya existe";
			break;

		case "ELIMINAR_NO_EXISTE":
			mensaje = "El registro no existe";
			break;

		case "TIPO_PRODUCTO_NO_EXISTE":
			mensaje = "El tipo de producto no existe";
			break;

		case "ORIGEN_NO_EXISTE":
			mensaje = "El origen no existe";
			break;
			
		case "PRODUCTO_NO_EXISTE":
			mensaje = "No existe producto";
			break;	
			
		case "SUPERA_STOCK":
			mensaje = "La cantidad del producto supera el stock";
			break;
			
		case "CANT_VALOR_MENOR_IGUAL_CERO":
			mensaje = "a cantidad o valor unitario de producto son menores o iguales a cero";
			break;
			
//		case "":
//			mensaje = "";
//			break;
		default:
			mensaje = "Ocurrió un error favor contactar al administrador.";
			break;
		}

		return mensaje;
	}
}
