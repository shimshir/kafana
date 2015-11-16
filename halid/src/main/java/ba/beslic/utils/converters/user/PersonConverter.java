package ba.beslic.utils.converters.user;

import ba.beslic.models.persistence.user.PersonEntity;
import ba.beslic.models.presentation.user.PersonData;
import ba.beslic.utils.converters.IdentifiableConverter;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("personConverter")
public class PersonConverter<PE extends PersonEntity, PD extends PersonData> extends IdentifiableConverter<PE, PD> {
	@Override
	public PD convertToData(PE entity, PD data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setFirstName(entity.getFirstName());
		data.setLastName(entity.getLastName());
		return data;
	}

	@Override
	public PE convertToEntity(PD data, PE entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setFirstName(data.getFirstName());
		entity.setLastName(data.getLastName());
		return entity;
	}
}
