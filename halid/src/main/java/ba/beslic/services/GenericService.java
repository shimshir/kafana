package ba.beslic.services;

import java.util.Collection;

/**
 * Author: Admir Memić
 * Date:   12.09.2015
 */
public interface GenericService<T> {
	Collection<T> query();
	T getById(Object id);
	void create(T t);
	void update(T t);
	void delete(Object id);
}
