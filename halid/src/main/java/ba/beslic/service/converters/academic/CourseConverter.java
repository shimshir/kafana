package ba.beslic.service.converters.academic;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.service.converters.Converter;
import ba.beslic.service.converters.academic.student.StudentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("courseConverter")
public class CourseConverter implements Converter<CourseEntity, CourseData> {

	@Autowired
	private StudentConverter studentConverter;

	@Override
	public CourseData convertToData(CourseEntity entity, CourseData data) {
		if (entity == null)
			return null;
		data.setName(entity.getName());
		data.setCode(entity.getCode());
		List<StudentData> students = entity.getStudents().stream().map(studentEntity ->
				  studentConverter.convertToData(studentEntity, new StudentData())).collect(Collectors.toList());
		data.setStudents(students);
		return data;
	}

	@Override
	public CourseEntity convertToEntity(CourseData data, CourseEntity entity) {
		if (data == null)
			return null;
		entity.setName(data.getName());
		entity.setCode(data.getCode());
		List<StudentEntity> students = data.getStudents().stream().map(studentData ->
				studentConverter.convertToEntity(studentData, new StudentEntity())).collect(Collectors.toList());
		entity.setStudents(students);
		return entity;
	}
}
