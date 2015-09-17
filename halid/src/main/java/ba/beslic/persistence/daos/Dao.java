package ba.beslic.persistence.daos;

import ba.beslic.persistence.entities.IdentifiableEntity;

import java.util.List;
import java.util.Map;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface Dao
{
	<T extends IdentifiableEntity> T getById(Class<T> clazz, int id, String... fetchProfiles);
	<T extends IdentifiableEntity> List<T> find(Class<T> clazz, Map<String, Object> params, String... fetchProfiles);
	<T extends IdentifiableEntity> T findUnique(Class<T> clazz, Map<String, Object> params, String... fetchProfiles);
	<T extends IdentifiableEntity> void save(T entity);
	<T extends IdentifiableEntity> void update(T entity);
	<T extends IdentifiableEntity> void delete(T entity);
}
