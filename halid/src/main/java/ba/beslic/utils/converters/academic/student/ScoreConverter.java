package ba.beslic.utils.converters.academic.student;

import ba.beslic.models.persistence.academic.ScoreEntity;
import ba.beslic.models.presentation.academic.student.ScoreData;
import ba.beslic.utils.converters.IdentifiableConverter;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("scoreConverter")
public class ScoreConverter extends IdentifiableConverter<ScoreEntity, ScoreData> {
	@Override
	public ScoreData convertToData(ScoreEntity entity, ScoreData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setCode(entity.getCode());
		data.setName(entity.getName());
		data.setValue(entity.getValue());
		return data;
	}

	@Override
	public ScoreEntity convertToEntity(ScoreData data, ScoreEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setCode(data.getCode());
		entity.setName(data.getName());
		entity.setValue(data.getValue());
		return entity;
	}
}
