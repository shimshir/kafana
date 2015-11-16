package ba.beslic.daos.user;

import ba.beslic.daos.Dao;
import ba.beslic.models.persistence.user.UserEntity;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserDao extends Dao {
	UserEntity getUserByAccountId(int account_id);
}
