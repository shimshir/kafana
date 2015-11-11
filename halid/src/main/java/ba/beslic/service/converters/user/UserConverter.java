package ba.beslic.service.converters.user;

import ba.beslic.persistence.entities.user.UserEntity;
import ba.beslic.presentation.data.user.UserData;
import ba.beslic.service.converters.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("userConverter")
public class UserConverter implements Converter<UserEntity, UserData> {
	@Autowired
	private AccountConverter accountConverter;

	@Override
	public UserData convertToData(UserEntity entity) {
		UserData data = new UserData();
		data.setFirstName(entity.getFirstName());
		data.setLastName(entity.getLastName());
		data.setAccount(accountConverter.convertToData(entity.getAccount()));
		return data;
	}

	@Override
	public UserEntity convertToEntity(UserData data) {
		return null;
	}
}
