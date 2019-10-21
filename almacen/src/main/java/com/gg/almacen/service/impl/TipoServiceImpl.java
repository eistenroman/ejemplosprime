package com.gg.almacen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gg.almacen.dao.TipoDAO;
import com.gg.almacen.model.Tipo;
import com.gg.almacen.service.TipoService;

@Service
public class TipoServiceImpl implements TipoService {
	@Autowired
	private TipoDAO tipoDAO;
	
	@Override
	public List<Tipo> obtenerTipos() {
		List<Tipo> tipos = new ArrayList<Tipo>();
		for(Tipo tipo: tipoDAO.findAll()) {
			tipos.add(tipo);
		}
		return tipos;
	}

	@Override
	public Tipo altaTipo(Tipo tipo) {
		return tipoDAO.save(tipo);
	}

}
