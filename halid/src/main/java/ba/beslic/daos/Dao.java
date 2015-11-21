package ba.beslic.daos;

import java.util.List;
import java.util.Map;


/**
 * Author:  Admir Memic
 * Date:    15.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface Dao
{
	<T> T getById(Class<T> clazz, int id);
	<T> List<T> find(Class<T> clazz, Map<String, Object> params);
	<T> T findUnique(Class<T> clazz, Map<String, Object> params);
	<T> void create(T entity);
	<T> void update(T entity);
	<T> void delete(T entity);
}
