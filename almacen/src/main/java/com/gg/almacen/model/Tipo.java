package com.gg.almacen.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tipo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String descripcion;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Tipo [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
