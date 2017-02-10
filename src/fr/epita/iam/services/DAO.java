package fr.epita.iam.services;


import java.util.List;
import java.util.Map;

import fr.epita.iam.exceptions.DAOInitializationException;

public interface DAO<T> {

	public void create(T entity) throws DAOInitializationException;
	public void update(T entity) throws DAOInitializationException;
	public void delete(T entity) throws DAOInitializationException;
    public T find(final Object id)throws DAOInitializationException;
    List<T> search(String[] keywords, T entity)throws DAOInitializationException;
	/**
	 * Read all entities of type T 
	 * @return list of entity of type T
	 * @throws DAOInitializationException
	 */
	List<T> readAll() throws DAOInitializationException;

}