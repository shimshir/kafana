package ba.beslic.service.converters.user;

import ba.beslic.persistence.entities.user.UserSessionEntity;
import ba.beslic.presentation.data.user.UserSessionData;
import ba.beslic.service.converters.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("userSessionConverter")
public class UserSessionConverter implements Converter<UserSessionEntity, UserSessionData> {
	@Autowired
	private UserConverter userConverter;

	@Override
	public UserSessionData convertToData(UserSessionEntity entity) {
		UserSessionData data = new UserSessionData();
		data.setActive(entity.isActive());
		data.setUser(userConverter.convertToData(entity.getUser()));
		return data;
	}

	@Override
	public UserSessionEntity convertToEntity(UserSessionData data) {
		return null;
	}
}
