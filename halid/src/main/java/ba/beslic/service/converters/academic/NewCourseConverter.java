package ba.beslic.service.converters.academic;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.service.converters.IdentifiableConverter;
import ba.beslic.service.converters.academic.student.NewStudentConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("courseConverter")
public class NewCourseConverter extends IdentifiableConverter<CourseEntity, CourseData> {

	@Autowired
	private NewStudentConverter studentConverter;

	@Override
	public CourseData convertToData(CourseEntity entity, CourseData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setName(entity.getName());
		data.setCode(entity.getCode());

		// students
		if (CollectionUtils.isNotEmpty(entity.getStudents())) {
			entity.getStudents().stream().forEach(studentEntity ->
					studentEntity.setCourses(studentEntity.getCourses().stream().filter(courseEntity ->
							courseEntity != entity).collect(Collectors.toList()))
			);
			data.setStudents(entity.getStudents().stream().map(courseEntity ->
					studentConverter.convertToData(courseEntity, new StudentData())
			).collect(Collectors.toList()));
			data.getStudents().forEach(studentData ->
					{
						if (CollectionUtils.isEmpty(studentData.getCourses()))
							studentData.setCourses(Collections.singletonList(data));
						else
							studentData.getCourses().add(data);
					}
			);
		}
		return data;
	}

	@Override
	public CourseEntity convertToEntity(CourseData data, CourseEntity entity) {
		if (data == null)
			return null;
		entity.setName(data.getName());
		entity.setCode(data.getCode());

		// students
		if (CollectionUtils.isNotEmpty(data.getStudents())) {
			entity.setStudents(data.getStudents().stream().map(
					  courseData -> studentConverter.convertToEntity(courseData, new StudentEntity())
			).collect(Collectors.toList()));
			entity.getStudents().forEach(studentEntity ->
					  {
						  if (CollectionUtils.isEmpty(studentEntity.getCourses()))
							  studentEntity.setCourses(Collections.singletonList(entity));
						  else
							  studentEntity.getCourses().add(entity);
					  }
			);
		}
		return entity;
	}
}
