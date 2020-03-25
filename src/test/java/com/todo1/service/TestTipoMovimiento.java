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

import com.todo1.model.TipoMovimiento;
import com.todo1.service.TipoMovimientoService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTipoMovimiento {
	@Mock
	private TipoMovimientoService mockServ;	

	@Test
	public void crearTipoMovimiento() {
		TipoMovimiento entity = mock(TipoMovimiento.class);	
		Mockito.when(mockServ.crear(entity)).thenReturn(entity);	
		assertEquals(mockServ.crear(entity),entity);			
	}
	
	@Test
	public void modificarTipoMovimiento() {
		TipoMovimiento entity = mock(TipoMovimiento.class);	
		Mockito.when(mockServ.modificar(entity)).thenReturn(entity);	
		assertEquals(mockServ.modificar(entity),entity);	
	}
	
	@Test
	public void eliminarTipoMovimiento() {	
		TipoMovimiento entity = mock(TipoMovimiento.class);	
		Mockito.when(mockServ.eliminar(entity)).thenReturn(true);	
		assertTrue(mockServ.eliminar(entity));	
	}
}
