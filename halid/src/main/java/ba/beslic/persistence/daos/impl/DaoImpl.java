package ba.beslic.persistence.daos.impl;

import ba.beslic.persistence.daos.Dao;
import ba.beslic.persistence.entities.IdentifiableEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
@SuppressWarnings("unchecked")
public class DaoImpl implements Dao
{
	@Autowired
	protected SessionFactory sessionFactory;
	@Override
	public <T extends IdentifiableEntity> T getById(Class<T> clazz, int id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return findUnique(clazz, params);
	}

	@Override
	public <T extends IdentifiableEntity> List<T> find(Class<T> clazz, Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.allEq(params));

		return criteria.list();
	}

	@Override
	public <T extends IdentifiableEntity> T findUnique(Class<T> clazz, Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.allEq(params));

		return (T) criteria.uniqueResult();
	}

	@Override
	public void create(IdentifiableEntity entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	}

	@Override
	public <T extends IdentifiableEntity> void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
	}

	@Override
	public <T extends IdentifiableEntity> void delete(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}
}
