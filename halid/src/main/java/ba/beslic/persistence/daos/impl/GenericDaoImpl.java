package ba.beslic.persistence.daos.impl;

import ba.beslic.persistence.daos.GenericDao;
import ba.beslic.persistence.entities.GenericEntity;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class GenericDaoImpl<T extends GenericEntity> implements GenericDao<T>
{
	@Autowired
	protected HibernateTemplate hibernateTemplate;

	private Class<T> clazz;

	@Override
	public T getById(int id)
	{
		return hibernateTemplate.get(clazz, id);
	}

	@Override
	public List<T> getAll()
	{
		return (List<T>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(clazz));
	}

	@Override
	public void save(T entity)
	{
		hibernateTemplate.save(entity);
	}

	@Override
	public void update(T entity)
	{
		hibernateTemplate.update(entity);
	}

	@Override
	public void delete(T entity)
	{
		hibernateTemplate.delete(entity);
	}
}
