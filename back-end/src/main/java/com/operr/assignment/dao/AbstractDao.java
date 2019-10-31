/*
 * @author 	:		agarw
 * @Date	:	 	31-Oct-2019
 * @Project :		places-backend
 * @Package : 		com.operr.assignment.dao
 * @Type	: 		AbstractDao
 */
package com.operr.assignment.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDao.
 *
 * @param <T> the generic type
 */
public class AbstractDao<T> {

	/** The mongo. */
	@Autowired
	MongoTemplate _mongo;

	/** The tclass. */
	private final Class<T> tclass;

	/**
	 * Instantiates a new abstract dao.
	 *
	 * @param type the type
	 */
	public AbstractDao(Class<T> type) {
		this.tclass = type;
	}

	/**
	 * Delete.
	 *
	 * @param entity the entity
	 */
	public void delete(T entity) {
		_mongo.remove(entity);
	}

	/**
	 * Exists.
	 *
	 * @param entity the entity
	 * @return the boolean
	 */
	public Boolean exists(T entity) {
		// TODO:Add method definition.
		return null;
	}

	/**
	 * Exists by id.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	public Boolean existsById(String id) {
		Query q = new Query();
		q.addCriteria(Criteria.where("id").is(id));
		
		return _mongo.exists(q, tclass);
	}

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public List<T> getAll() {
		return _mongo.findAll(tclass);
	}

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	public T getById(String id) {

		return _mongo.findById(id, tclass);
	}

	/**
	 * Insert.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T insert(T entity) {
		return _mongo.insert(entity);
	}

	/**
	 * Update.
	 *
	 * @param entity the entity
	 * @return the t
	 */
	public T update(T entity) {
		return _mongo.save(entity);
	}

}
