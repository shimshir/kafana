package ba.beslic.persistence.daos.user;

import ba.beslic.persistence.daos.Dao;
import ba.beslic.persistence.entities.user.UserEntity;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserDao extends Dao {
	UserEntity getUserByAccountId(int account_id);
}
