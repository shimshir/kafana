package ba.beslic.service.converters.academic;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.service.converters.IdentifiableConverter;
import ba.beslic.service.converters.academic.student.StudentConverter;
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
@Component("oldCourseConverter")
public class CourseConverter extends IdentifiableConverter<CourseEntity, CourseData> {

	@Autowired
	private StudentConverter studentConverter;

	@Override
	public CourseData convertToData(CourseEntity entity, CourseData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setName(entity.getName());
		data.setCode(entity.getCode());

		if (CollectionUtils.isEmpty(entity.getStudents())) {
			data.setStudents(entity.getStudents() == null ? null : new ArrayList<>());
		} else {
			entity.getStudents().forEach((studentEntity) ->
			{
				if (studentEntity.getCourses() == null)
					studentEntity.setCourses(new ArrayList<>());
				if (!studentEntity.getCourses().contains(entity))
					studentEntity.getCourses().add(entity);
			});
		}
		if (CollectionUtils.isNotEmpty(entity.getStudents()) && CollectionUtils.isEmpty(data.getStudents())) {
			List<StudentData> students = entity.getStudents().stream().map((studentEntity) ->
					{
						StudentData studentData = new StudentData();
						studentData.setCourses(new ArrayList<>(Collections.singletonList(data)));
						return studentConverter.convertToData(studentEntity, studentData);
					}
			).collect(Collectors.toList());
			data.setStudents(students);
		}
		return data;
	}

	@Override
	public CourseEntity convertToEntity(CourseData data, CourseEntity entity) {
		if (data == null)
			return null;
		entity.setName(data.getName());
		entity.setCode(data.getCode());

		if (CollectionUtils.isEmpty(data.getStudents())) {
			entity.setStudents(data.getStudents() == null ? null : new ArrayList<>());
		} else {
			data.getStudents().forEach((studentData) ->
			{
				if (studentData.getCourses() == null)
					studentData.setCourses(new ArrayList<>());
				if (!studentData.getCourses().contains(data))
					studentData.getCourses().add(data);
			});
		}
		if (CollectionUtils.isEmpty(entity.getStudents()) && CollectionUtils.isNotEmpty(data.getStudents())) {
			List<StudentEntity> students = data.getStudents().stream().map((studentData) ->
					{
						StudentEntity studentEntity = new StudentEntity();
						studentEntity.setCourses(new ArrayList<>(Collections.singletonList(entity)));
						return studentConverter.convertToEntity(studentData, studentEntity);
					}
			).collect(Collectors.toList());
			entity.setStudents(students);
		}
		return entity;
	}
}
