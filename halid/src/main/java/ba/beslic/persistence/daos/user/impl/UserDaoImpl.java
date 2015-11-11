package ba.beslic.persistence.daos.user.impl;

import ba.beslic.persistence.daos.impl.DaoImpl;
import ba.beslic.persistence.daos.user.UserDao;
import ba.beslic.persistence.entities.user.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Repository("userDao")
public class UserDaoImpl extends DaoImpl implements UserDao {
	@Override
	public UserEntity getUserByAccountId(int account_id) {
		return null;
	}
}
