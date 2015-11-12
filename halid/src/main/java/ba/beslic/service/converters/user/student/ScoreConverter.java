package ba.beslic.service.converters.user.student;

import ba.beslic.persistence.entities.user.student.ScoreEntity;
import ba.beslic.presentation.data.user.student.ScoreData;
import ba.beslic.service.converters.Converter;
import org.springframework.stereotype.Component;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("scoreConverter")
public class ScoreConverter implements Converter<ScoreEntity, ScoreData> {
	@Override
	public ScoreData convertToData(ScoreEntity entity, ScoreData data) {
		data.setCode(entity.getCode());
		data.setName(entity.getName());
		data.setValue(entity.getValue());
		return data;
	}

	@Override
	public ScoreEntity convertToEntity(ScoreData data, ScoreEntity entity) {
		entity.setCode(data.getCode());
		entity.setName(data.getName());
		entity.setValue(data.getValue());
		return entity;
	}
}
