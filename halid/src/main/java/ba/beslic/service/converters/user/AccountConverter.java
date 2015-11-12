package ba.beslic.service.converters.user;

import ba.beslic.persistence.entities.user.AccountEntity;
import ba.beslic.presentation.data.user.AccountData;
import ba.beslic.service.converters.Converter;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("accountConverter")
public class AccountConverter implements Converter<AccountEntity, AccountData> {
	@Override
	public AccountData convertToData(AccountEntity entity, AccountData data) {
		if (entity == null)
			return null;
		data.setUsername(entity.getUsername());
		data.setRoles(entity.getRoles());
		return data;
	}

	@Override
	public AccountEntity convertToEntity(AccountData data, AccountEntity entity) {
		if (data == null)
			return null;
		entity.setUsername(data.getUsername());
		entity.setRoles(data.getRoles());
		return entity;
	}
}
