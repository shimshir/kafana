package ba.beslic.service.converters.user;

import ba.beslic.persistence.entities.user.AccountEntity;
import ba.beslic.presentation.data.user.AccountData;
import ba.beslic.service.converters.IdentifiableConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("accountConverter")
public class AccountConverter extends IdentifiableConverter<AccountEntity, AccountData> {

	@Autowired
	private ShaPasswordEncoder passwordEncoder;

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
		return data;
	}

	@Override
	public AccountEntity convertToEntity(AccountData data, AccountEntity entity) {
		if (data == null)
			return null;
		entity.setUsername(data.getUsername());
		entity.setHashedPassword(passwordEncoder.encodePassword(data.getPassword(), data.getUsername()
				+ "where luck miracles to happen, so that miljacka bridges carried away" + data.getPassword()));
		entity.setRoles(data.getRoles());
		return entity;
	}
}
