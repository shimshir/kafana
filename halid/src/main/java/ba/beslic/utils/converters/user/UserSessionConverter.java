package ba.beslic.utils.converters.user;

import ba.beslic.models.persistence.user.UserEntity;
import ba.beslic.models.persistence.user.UserSessionEntity;
import ba.beslic.models.presentation.user.UserData;
import ba.beslic.models.presentation.user.UserSessionData;
import ba.beslic.utils.converters.IdentifiableConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("userSessionConverter")
public class UserSessionConverter extends IdentifiableConverter<UserSessionEntity, UserSessionData> {
	@Autowired
	private UserConverter<UserEntity, UserData> userConverter;

	@Override
	public UserSessionData convertToData(UserSessionEntity entity, UserSessionData data) {
		super.convertToData(entity, data);
		data.setActive(entity.isActive());
		data.setUser(userConverter.convertToData(entity.getUser(), new UserData()));
		return data;
	}

	@Override
	public UserSessionEntity convertToEntity(UserSessionData data, UserSessionEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setActive(data.isActive());
		entity.setUser(userConverter.convertToEntity(data.getUser(), new UserEntity()));
		return entity;
	}
}
