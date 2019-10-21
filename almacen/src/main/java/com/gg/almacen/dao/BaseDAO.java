package com.gg.almacen.dao;

import java.util.List;

public interface BaseDAO<T, Id> {
	List<T> findAll();
	T findById(Id id);
	void save(T t);
	T update(T t);
	boolean delete(T entidad);
}
