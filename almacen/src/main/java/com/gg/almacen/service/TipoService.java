package com.gg.almacen.service;

import java.util.List;

import com.gg.almacen.model.Tipo;

public interface TipoService {
	List<Tipo> obtenerTipos();
	Tipo altaTipo(Tipo tipo);
}
