package ba.beslic.utils.converters.academic.student;

import ba.beslic.models.persistence.academic.CourseEntity;
import ba.beslic.models.persistence.academic.ScoreEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.presentation.IdentifiableData;
import ba.beslic.models.presentation.academic.CourseData;
import ba.beslic.models.presentation.academic.student.ScoreData;
import ba.beslic.models.presentation.academic.student.StudentData;
import ba.beslic.utils.converters.academic.CourseConverter;
import ba.beslic.utils.converters.user.UserConverter;
import ba.beslic.services.academic.AcademicService;
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
@Component("studentConverter")
public class StudentConverter extends UserConverter<StudentEntity, StudentData> {
	@Autowired
	private ScoreConverter scoreConverter;
	@Autowired
	private CourseConverter courseConverter;
	@Autowired
	private AcademicService academicService;

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
		if (CollectionUtils.isNotEmpty(entity.getCourses()) && CollectionUtils.isEmpty(data.getCourses())) {
			data.setCourses(entity.getCourses().stream().map(courseEntity ->
					{
						CourseData courseData = new CourseData();
						courseData.setStudents(Collections.singletonList(data));
						courseConverter.convertToData(courseEntity, courseData);
						return courseData;
					}
			).collect(Collectors.toList()));
		}
		if (CollectionUtils.isNotEmpty(data.getCourses()))
			data.setCourseIds(data.getCourses().stream().map(IdentifiableData::getId).collect(Collectors.toList()));
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
		if (CollectionUtils.isNotEmpty(data.getCourseIds())) {
			if (entity.getCourses() == null) {
				entity.setCourses(new ArrayList<>());
			}
			data.getCourseIds().forEach(courseId -> entity.getCourses().add(academicService.getCourseById(courseId)));
		}

		return entity;
	}
}
