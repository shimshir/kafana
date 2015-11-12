package ba.beslic.service.converters.user.student;

import ba.beslic.persistence.entities.user.student.ScoreEntity;
import ba.beslic.persistence.entities.user.student.StudentEntity;
import ba.beslic.presentation.data.user.student.ScoreData;
import ba.beslic.presentation.data.user.student.StudentData;
import ba.beslic.service.converters.user.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("studentConverter")
public class StudentConverter<SE extends StudentEntity, SD extends StudentData> extends UserConverter<SE, SD> {

	@Autowired
	private ScoreConverter scoreConverter;

	@Override
	public SD convertToData(SE entity, SD data) {
		if (entity == null)
			return null;
		data = super.convertToData(entity, data);
		data.setCardCode(entity.getCardCode());
		List<ScoreData> scores = entity.getScores().stream().map
				  (scoreEntity -> scoreConverter.convertToData(scoreEntity, new ScoreData())).collect(Collectors.toList());
		data.setScores(scores);
		return data;
	}

	@Override
	public SE convertToEntity(SD data, SE entity) {
		if (data == null)
			return null;
		entity = super.convertToEntity(data, entity);
		entity.setCardCode(data.getCardCode());
		List<ScoreEntity> scores = data.getScores().stream().map
				(scoreData -> scoreConverter.convertToEntity(scoreData, new ScoreEntity())).collect(Collectors.toList());
		entity.setScores(scores);
		return entity;
	}
}
