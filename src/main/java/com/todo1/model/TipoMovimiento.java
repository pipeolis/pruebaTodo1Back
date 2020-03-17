package com.todo1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class TipoMovimiento {
	@GeneratedValue
	@Id
	private int idTipoMovmiento;
	
	@Column (name = "descripcion", length = 50)
	private String descripcion;
	
	public int getIdTipoMovmiento() {
		return idTipoMovmiento;
	}
	public void setIdTipoMovmiento(int idTipoMovmiento) {
		this.idTipoMovmiento = idTipoMovmiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
