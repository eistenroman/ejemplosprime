package com.gg.almacen.controller;

import java.util.List;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gg.almacen.model.Almacen;
import com.gg.almacen.model.Tipo;
import com.gg.almacen.service.AlmacenService;
import com.gg.almacen.service.TipoService;

@RestController
@RequestMapping("/Almacen")
public class AlmacenController {
	
	public final static Logger logger = Logger.getLogger(AlmacenController.class);
	@Autowired
	TipoService tipoService;
	@Autowired
	AlmacenService almacenService;
	
	@RequestMapping("/todos")
	public List<Almacen> almacenTodos(){
		return almacenService.almacenesExistentes();
	}
	
	@RequestMapping(value = "/alta", method = RequestMethod.POST)
	public void guardarTipo(@Valid @RequestBody Almacen almacen) {
		try{
			logger.info("Tipo ["+ almacen +"]" );
			almacenService.agregaAlmacen(almacen);
		}catch (Exception e){
			logger.info("error "+ e.getMessage());
		}
	}
	
	@RequestMapping("/tipo/todos")
	public List<Tipo> tipoTodos(){
		return tipoService.obtenerTipos();
	}
	
	@RequestMapping(value = "/tipo/alta", method = RequestMethod.POST)
	public Tipo guardarTipo(@Valid @RequestBody Tipo tipo) {
		try{
			logger.info("Tipo ["+ tipo +"]" );
			return tipoService.altaTipo(tipo);
		}catch (Exception e){
			logger.info("error "+ e.getMessage());
			return null;
		}
	}
	
}
