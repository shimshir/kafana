package ba.beslic.service.services.user;

import ba.beslic.persistence.entities.user.UserEntity;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserService {
	UserEntity getUserById(int id);
}
