package ba.beslic.service.converters;

import ba.beslic.persistence.entities.IdentifiableEntity;
import ba.beslic.presentation.data.PresentationData;


/**
 * Author:  Admir Memic
 * Date:    17.09.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface Converter<ENTITY extends IdentifiableEntity, DATA extends PresentationData>
{
	DATA convertToData(ENTITY entity, DATA data);
	ENTITY convertToEntity(DATA data, ENTITY entity);
}
