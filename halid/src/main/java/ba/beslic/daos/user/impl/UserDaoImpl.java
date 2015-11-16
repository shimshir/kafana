package ba.beslic.daos.user.impl;

import ba.beslic.daos.user.UserDao;
import ba.beslic.daos.impl.DaoImpl;
import ba.beslic.models.persistence.user.UserEntity;
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
