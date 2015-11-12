package ba.beslic.service.converters.user;

import ba.beslic.persistence.entities.user.PersonEntity;
import ba.beslic.presentation.data.user.PersonData;
import ba.beslic.service.converters.Converter;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("personConverter")
public class PersonConverter<PE extends PersonEntity, PD extends PersonData> implements Converter<PE, PD> {
	@Override
	public PD convertToData(PE entity, PD data) {
		if (entity == null)
			return null;
		data.setFirstName(entity.getFirstName());
		data.setLastName(entity.getLastName());
		return data;
	}

	@Override
	public PE convertToEntity(PD data, PE entity) {
		if (data == null)
			return null;
		entity.setFirstName(data.getFirstName());
		entity.setLastName(data.getLastName());
		return entity;
	}
}
