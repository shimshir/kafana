package ba.beslic.utils.converters.user;

import ba.beslic.models.persistence.user.AccountEntity;
import ba.beslic.models.persistence.user.UserEntity;
import ba.beslic.models.presentation.user.AccountData;
import ba.beslic.models.presentation.user.UserData;
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
		if (entity.getAccount() != null && data.getAccount() == null) {
			AccountData accountData = new AccountData();
			accountData.setUser(data);
			data.setAccount(accountConverter.convertToData(entity.getAccount(), accountData));
		}
		return data;
	}

	@Override
	public UE convertToEntity(UD data, UE entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		if (data.getAccount() != null && entity.getAccount() == null) {
			AccountEntity accountEntity = new AccountEntity();
			accountEntity.setUser(entity);
			entity.setAccount(accountConverter.convertToEntity(data.getAccount(), accountEntity));
		}
		return entity;
	}
}
