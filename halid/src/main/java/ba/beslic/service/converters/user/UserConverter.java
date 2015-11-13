package ba.beslic.service.converters.user;

import ba.beslic.persistence.entities.user.AccountEntity;
import ba.beslic.persistence.entities.user.UserEntity;
import ba.beslic.presentation.data.user.AccountData;
import ba.beslic.presentation.data.user.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("userConverter")
public class UserConverter<UE extends UserEntity, UD extends UserData> extends PersonConverter<UE, UD> {
	@Autowired
	private AccountConverter accountConverter;

	@Override
	public UD convertToData(UE entity, UD data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setAccount(accountConverter.convertToData(entity.getAccount(), new AccountData()));
		return data;
	}

	@Override
	public UE convertToEntity(UD data, UE entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setAccount(accountConverter.convertToEntity(data.getAccount(), new AccountEntity()));
		return entity;
	}
}
