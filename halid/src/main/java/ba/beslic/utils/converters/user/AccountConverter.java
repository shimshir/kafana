package ba.beslic.utils.converters.user;

import ba.beslic.models.persistence.user.AccountEntity;
import ba.beslic.models.persistence.user.UserEntity;
import ba.beslic.models.presentation.user.AccountData;
import ba.beslic.models.presentation.user.UserData;
import ba.beslic.services.user.UserService;
import ba.beslic.utils.converters.IdentifiableConverter;
import ba.beslic.utils.security.PasswordEncoderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("accountConverter")
public class AccountConverter extends IdentifiableConverter<AccountEntity, AccountData> {

	@Autowired
	private PasswordEncoderWrapper passwordEncoder;
	@Autowired
	private UserConverter<UserEntity, UserData> userConverter;
	@Autowired
	private UserService userService;

	@Override
	public AccountData convertToData(AccountEntity entity, AccountData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setUsername(entity.getUsername());
		// force hibernate to load all the roles
		if (entity.getRoles() != null)
			for (Object o : entity.getRoles());
		//
		data.setRoles(entity.getRoles());
		if (entity.getUser() != null && data.getUser() == null) {
			UserData userData = new UserData();
			userData.setAccount(data);
			data.setUser(userConverter.convertToData(entity.getUser(), userData));
			data.setUserId(entity.getUser().getId());
		}
		return data;
	}

	@Override
	public AccountEntity convertToEntity(AccountData data, AccountEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setUsername(data.getUsername());
		entity.setHashedPassword(passwordEncoder.encode(data.getUsername(), data.getPassword()));
		entity.setRoles(data.getRoles());
		if (data.getUser() != null && data.getUserId() == null && entity.getUser() == null) {
			UserEntity userEntity = new UserEntity();
			userEntity.setAccount(entity);
			entity.setUser(userConverter.convertToEntity(data.getUser(), userEntity));
		} else if (data.getUser() == null && data.getUserId() != null) {
			entity.setUser(userService.getUserById(data.getUserId()));
		} else if (data.getUser() != null && data.getUserId() != null) {
			throw new UnsupportedOperationException("Ambigous user!");
		}
		return entity;
	}
}
