package ba.beslic.persistence.daos.impl;

import ba.beslic.persistence.daos.GenericDao;
import ba.beslic.persistence.entities.GenericEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T extends GenericEntity> implements GenericDao<T>
{
	@Autowired
	protected SessionFactory sessionFactory;

	protected Class<T> clazz;

	/**
	 * Needed for setting clazz to the generic class T
	 */
	@PostConstruct
	protected abstract void init();

	@Override
	public T getById(int id, String... fetchProfiles)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return findUnique(params, fetchProfiles);
	}

	@Override
	public List<T> find(Map<String, Object> params, String... fetchProfiles)
	{
		try (Session session = sessionFactory.openSession())
		{
			for(String fetchProfile : fetchProfiles)
			{
				session.enableFetchProfile(fetchProfile);
			}
			Criteria criteria = session.createCriteria(clazz);
			criteria.add(Restrictions.allEq(params));

			return criteria.list();
		}
	}

	@Override
	public T findUnique(Map<String, Object> params, String... fetchProfiles)
	{
		try (Session session = sessionFactory.openSession())
		{
			for(String fetchProfile : fetchProfiles)
			{
				session.enableFetchProfile(fetchProfile);
			}
			Criteria criteria = session.createCriteria(clazz);
			criteria.add(Restrictions.allEq(params));

			return (T) criteria.uniqueResult();
		}
	}

	@Override
	public void save(T entity)
	{
		try (Session session = sessionFactory.openSession())
		{
			session.save(entity);
		}
	}

	@Override
	public void update(T entity)
	{
		try (Session session = sessionFactory.openSession())
		{
			session.update(entity);
		}
	}

	@Override
	public void delete(T entity)
	{
		try (Session session = sessionFactory.openSession())
		{
			session.delete(entity);
		}
	}
}
