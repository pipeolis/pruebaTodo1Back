package com.todo1.service;


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.model.TipoProducto;
import com.todo1.service.TipoProductoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTipoProducto {
	@Mock
	private TipoProductoService mockServ;	

	@Test
	public void crearTipoProducto() {
		TipoProducto entity = mock(TipoProducto.class);	
		Mockito.when(mockServ.crear(entity)).thenReturn(entity);	
		assertEquals(mockServ.crear(entity),entity);			
	}
	
	@Test
	public void modificarTipoProducto() {
		TipoProducto entity =  mock(TipoProducto.class);		
		Mockito.when(mockServ.modificar(entity)).thenReturn(entity);	
		assertEquals(mockServ.modificar(entity),entity);	
	}
	
	@Test
	public void eliminarTipoProducto() {	
		TipoProducto entity = mock(TipoProducto.class);	
		Mockito.when(mockServ.eliminar(entity)).thenReturn(true);	
		assertTrue(mockServ.eliminar(entity));	
	}
}
