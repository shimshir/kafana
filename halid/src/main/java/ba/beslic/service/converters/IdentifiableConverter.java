package ba.beslic.service.converters;

import ba.beslic.persistence.entities.IdentifiableEntity;
import ba.beslic.presentation.data.IdentifiableData;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public abstract class IdentifiableConverter<ENTITY extends IdentifiableEntity, DATA extends IdentifiableData>
{
	public DATA convertToData(ENTITY entity, DATA data) {
		data.setId(entity.getId());
		return data;
	}
	public ENTITY convertToEntity(DATA data, ENTITY entity) {
		entity.setId(data.getId());
		return entity;
	}
}
