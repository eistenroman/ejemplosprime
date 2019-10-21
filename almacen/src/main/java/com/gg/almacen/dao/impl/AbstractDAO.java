package com.gg.almacen.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import com.gg.almacen.dao.BaseDAO;

@Transactional
public class AbstractDAO<T, Id> implements BaseDAO<T, Id> {
	final static Logger logger = Logger.getLogger(AbstractDAO.class);
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	private final Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.entityClass =(Class<T>) ((ParameterizedType) 
				this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String hql = "FROM ".concat(entityClass.getName());
		return entityManager.createQuery(hql).getResultList();
	}

	@Override
	public T findById(Id id) {
		return (T) entityManager.find(entityClass, id);
	}

	@Override
	public void save(Object t) {
		entityManager.persist(t);
	}

	@Override
	public T update(T t) {
		return entityManager.merge(t);
	}

	@Override
	public boolean delete(Object entidad) {
		boolean updated = false;
		try {		
			entityManager.remove(entityManager.contains(entidad) ? entidad : entityManager.merge(entidad) );
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return updated;
	}
	
}
