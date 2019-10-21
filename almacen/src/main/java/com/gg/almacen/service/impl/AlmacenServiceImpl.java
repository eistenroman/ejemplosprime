package com.gg.almacen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.almacen.dao.AlmacenDAO;
import com.gg.almacen.model.Almacen;
import com.gg.almacen.service.AlmacenService;

@Service
public class AlmacenServiceImpl implements AlmacenService {
	
	@Autowired
	AlmacenDAO almacenDAO;
	
	@Override
	public Almacen buscaAlmacen(Integer id) {
		return almacenDAO.findById(id);
	}

	@Override
	public List<Almacen> almacenesExistentes() {
		return almacenDAO.findAll();
	}

	@Override
	public void agregaAlmacen(Almacen almacen) {
		almacenDAO.save(almacen);
	}

	@Override
	public Almacen actualizaAlmacen(Almacen almacen) {
		return almacenDAO.update(almacen);
	}

	@Override
	public void borraAlmacen(Integer idAlmacen) {
		Almacen entidad = almacenDAO.findById(idAlmacen);
		almacenDAO.delete(entidad);
	}

}
