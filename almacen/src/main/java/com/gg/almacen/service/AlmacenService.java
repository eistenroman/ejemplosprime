package com.gg.almacen.service;

import java.util.List;

import com.gg.almacen.model.Almacen;

public interface AlmacenService {
	Almacen buscaAlmacen(Integer id);
	List<Almacen> almacenesExistentes();
	void agregaAlmacen(Almacen almacen);
	Almacen actualizaAlmacen(Almacen almacen);
	void borraAlmacen(Integer idAlmacen);
}
