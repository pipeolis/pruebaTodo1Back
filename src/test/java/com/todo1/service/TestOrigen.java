package com.todo1.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todo1.model.Origen;
import com.todo1.service.OrigenService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrigen {
	@Mock
	private OrigenService mockServ;		

	@Test
	public void crearOrigen() {
		Origen entity = mock(Origen.class);	
		Mockito.when(mockServ.crear(entity)).thenReturn(entity);	
		assertEquals(mockServ.crear(entity),entity);	
	}
	
	@Test
	public void modificarOrigen() {
		Origen entity = mock(Origen.class);	
		Mockito.when(mockServ.modificar(entity)).thenReturn(entity);	
		assertEquals(mockServ.modificar(entity),entity);	
	}
	
	@Test
	public void eliminarOrigen() {
		Origen entity = mock(Origen.class);	
		Mockito.when(mockServ.eliminar(entity)).thenReturn(true);	
		assertTrue(mockServ.eliminar(entity));	
	}
	
}
