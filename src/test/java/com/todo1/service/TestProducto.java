package com.todo1.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.model.Producto;
import com.todo1.service.ProductoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProducto {
	@Mock
	private ProductoService mockServ;
	@Test
	public void crearProducto() {
		Producto entity = new Producto();
		entity.setDescripcion("NUEVO PRODUCTO");
		entity.setIdOrigen(9);
		entity.setIdTipo(22);
		entity.setPorcVenta(30.0);
		Mockito.when(mockServ.crear(entity)).thenReturn(entity);	
		assertEquals(mockServ.crear(entity),entity);	

	}
	
	@Test
	public void modificarProducto() {
		Producto entity = new Producto();
		entity.setDescripcion("Otro producto 2");
		entity.setIdOrigen(10);
		entity.setIdTipo(23);
		entity.setPorcVenta(25.0);
		Mockito.when(mockServ.modificar(entity)).thenReturn(entity);	
		assertEquals(mockServ.modificar(entity),entity);	
	}
	
	@Test
	public void eliminarProducto() {
		Producto entity = new Producto();
		entity.setDescripcion("Otro producto 2");
		entity.setIdOrigen(10);
		entity.setIdTipo(23);
		entity.setPorcVenta(25.0);
		Mockito.when(mockServ.eliminar(entity)).thenReturn(true);	
		assertTrue(mockServ.eliminar(entity));	
	}
}
