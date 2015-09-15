package ba.beslic.persistence.daos;

import ba.beslic.persistence.entities.GenericEntity;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface GenericDao<T extends GenericEntity>
{
	T getById(int id);
	List<T> getAll();
	void save(T entity);
	void update(T entity);
	void delete(T entity);
}
