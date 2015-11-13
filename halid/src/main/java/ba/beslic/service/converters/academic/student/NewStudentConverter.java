package ba.beslic.service.converters.academic.student;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.persistence.entities.academic.ScoreEntity;
import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.academic.student.ScoreData;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.service.converters.academic.NewCourseConverter;
import ba.beslic.service.converters.user.UserConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("studentConverter")
public class NewStudentConverter extends UserConverter<StudentEntity, StudentData> {
	@Autowired
	private ScoreConverter scoreConverter;
	@Autowired
	private NewCourseConverter courseConverter;

	@Override
	public StudentData convertToData(StudentEntity entity, StudentData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setCardCode(entity.getCardCode());
		if (CollectionUtils.isNotEmpty(entity.getScores())) {
			List<ScoreData> scores = entity.getScores().stream().map
					  (scoreData -> scoreConverter.convertToData(scoreData, new ScoreData())).collect(Collectors.toList());
			data.setScores(scores);
		} else {
			data.setScores(entity.getScores() == null ? null : new ArrayList<>());
		}

		// courses
		if (CollectionUtils.isNotEmpty(entity.getCourses())) {
			entity.getCourses().stream().forEach(courseEntity ->
					courseEntity.setStudents(courseEntity.getStudents().stream().filter(studentEntity ->
							studentEntity != entity).collect(Collectors.toList()))
			);
			data.setCourses(entity.getCourses().stream().map(courseEntity ->
					  courseConverter.convertToData(courseEntity, new CourseData())
			).collect(Collectors.toList()));
			data.getCourses().forEach(courseData ->
					  {
						  if (CollectionUtils.isEmpty(courseData.getStudents()))
							  courseData.setStudents(Collections.singletonList(data));
						  else
							  courseData.getStudents().add(data);
					  }
			);
		}

		return data;
	}

	@Override
	public StudentEntity convertToEntity(StudentData data, StudentEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		entity.setCardCode(data.getCardCode());
		if (CollectionUtils.isNotEmpty(data.getScores())) {
			List<ScoreEntity> scores = data.getScores().stream().map
					  (scoreData -> scoreConverter.convertToEntity(scoreData, new ScoreEntity())).collect(Collectors.toList());
			entity.setScores(scores);
		} else {
			entity.setScores(data.getScores() == null ? null : new ArrayList<>());
		}

		// courses
		if (CollectionUtils.isNotEmpty(data.getCourses())) {
			entity.setCourses(data.getCourses().stream().map((courseData) ->
					  courseConverter.convertToEntity(courseData, new CourseEntity())
			).collect(Collectors.toList()));
			entity.getCourses().forEach(courseEntity ->
					  {
						  if (CollectionUtils.isEmpty(courseEntity.getStudents()))
							  courseEntity.setStudents(Collections.singletonList(entity));
						  else
							  courseEntity.getStudents().add(entity);
					  }
			);
		}

		return entity;
	}
}
