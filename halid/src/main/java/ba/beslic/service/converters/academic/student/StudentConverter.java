package ba.beslic.service.converters.academic.student;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.persistence.entities.academic.ScoreEntity;
import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.academic.student.ScoreData;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.service.converters.academic.CourseConverter;
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
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("oldStudentConverter")
public class StudentConverter extends UserConverter<StudentEntity, StudentData> {

	@Autowired
	private ScoreConverter scoreConverter;
	@Autowired
	private CourseConverter courseConverter;

	@Override
	public StudentData convertToData(StudentEntity entity, StudentData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setCardCode(entity.getCardCode());
		if (CollectionUtils.isNotEmpty(entity.getScores())) {
			List<ScoreData> scores = entity.getScores().stream().map
					(scoreEntity -> scoreConverter.convertToData(scoreEntity, new ScoreData())).collect(Collectors.toList());
			data.setScores(scores);
		} else {
			data.setScores(entity.getScores() == null ? null : new ArrayList<>());
		}

		if (CollectionUtils.isEmpty(entity.getCourses())) {
			data.setCourses(entity.getCourses() == null ? null : new ArrayList<>());
		} else {
			entity.getCourses().forEach((courseEntity) ->
			{
				if (courseEntity.getStudents() == null)
					courseEntity.setStudents(new ArrayList<>());
				if (!courseEntity.getStudents().contains(entity))
					courseEntity.getStudents().add(entity);
			});
		}
		if (CollectionUtils.isNotEmpty(entity.getCourses()) && CollectionUtils.isEmpty(data.getCourses())) {
			List<CourseData> courses = entity.getCourses().stream().map((courseEntity) ->
					{
						CourseData courseData = new CourseData();
						courseData.setStudents(new ArrayList<>(Collections.singletonList(data)));
						return courseConverter.convertToData(courseEntity, courseData);
					}
			).collect(Collectors.toList());
			data.setCourses(courses);
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

		if (CollectionUtils.isEmpty(data.getCourses())) {
			entity.setCourses(data.getCourses() == null ? null : new ArrayList<>());
		} else {
			data.getCourses().forEach((courseData) ->
			{
				if (courseData.getStudents() == null)
					courseData.setStudents(new ArrayList<>());
				if (!courseData.getStudents().contains(data))
					courseData.getStudents().add(data);
			});
		}

		if (CollectionUtils.isEmpty(entity.getCourses()) && CollectionUtils.isNotEmpty(data.getCourses())) {
			List<CourseEntity> courses = data.getCourses().stream().map((courseData) ->
					{
						CourseEntity courseEntity = new CourseEntity();
						courseEntity.setStudents(new ArrayList<>(Collections.singletonList(entity)));
						return courseConverter.convertToEntity(courseData, courseEntity);
					}
			).collect(Collectors.toList());
			entity.setCourses(courses);
		}
		return entity;
	}
}
