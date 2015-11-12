package ba.beslic.service.converters.academic.student;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.persistence.entities.academic.ScoreEntity;
import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.academic.student.ScoreData;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.service.converters.academic.CourseConverter;
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
public class StudentConverter extends UserConverter<StudentEntity, StudentData> {

	@Autowired
	private ScoreConverter scoreConverter;
	@Autowired
	private CourseConverter courseConverter;

	@Override
	public StudentData convertToData(StudentEntity entity, StudentData data) {
		if (entity == null)
			return null;
		data = super.convertToData(entity, data);
		data.setCardCode(entity.getCardCode());
		List<ScoreData> scores = entity.getScores().stream().map
				  (scoreEntity -> scoreConverter.convertToData(scoreEntity, new ScoreData())).collect(Collectors.toList());
		data.setScores(scores);
		List<CourseData> courses = entity.getCourses().stream().map
				(courseEntity -> courseConverter.convertToData(courseEntity, new CourseData())).collect(Collectors.toList());
		data.setCourses(courses);
		return data;
	}

	@Override
	public StudentEntity convertToEntity(StudentData data, StudentEntity entity) {
		if (data == null)
			return null;
		entity = super.convertToEntity(data, entity);
		entity.setCardCode(data.getCardCode());
		List<ScoreEntity> scores = data.getScores().stream().map
				(scoreData -> scoreConverter.convertToEntity(scoreData, new ScoreEntity())).collect(Collectors.toList());
		entity.setScores(scores);

		// TODO: Solve the StackOverflowError caused by this
		// data.getCourses().forEach(courseData -> courseData.getStudents().add(data));

		List<CourseEntity> courses = data.getCourses().stream().map
				(courseData -> courseConverter.convertToEntity(courseData, new CourseEntity())).collect(Collectors.toList());
		entity.setCourses(courses);
		return entity;
	}
}
