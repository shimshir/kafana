package ba.beslic.utils.converters.academic;

import ba.beslic.models.persistence.academic.CourseEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.presentation.IdentifiableData;
import ba.beslic.models.presentation.academic.CourseData;
import ba.beslic.models.presentation.academic.student.StudentData;
import ba.beslic.utils.converters.IdentifiableConverter;
import ba.beslic.utils.converters.academic.student.StudentConverter;
import ba.beslic.services.user.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("courseConverter")
public class CourseConverter extends IdentifiableConverter<CourseEntity, CourseData> {

	@Autowired
	private StudentConverter studentConverter;
	@Autowired
	private UserService userService;

	@Override
	public CourseData convertToData(CourseEntity entity, CourseData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		data.setName(entity.getName());
		data.setCode(entity.getCode());

		// students
		if (CollectionUtils.isNotEmpty(entity.getStudents()) && CollectionUtils.isEmpty(data.getStudents())) {
			data.setStudents(entity.getStudents().stream().map(studentEntity ->
					{
						StudentData studentData = new StudentData();
						studentData.setCourses(Collections.singletonList(data));
						studentConverter.convertToData(studentEntity, studentData);
						return studentData;
					}
			).collect(Collectors.toList()));
		}
		if (CollectionUtils.isNotEmpty(data.getStudents()))
			data.setStudentIds(data.getStudents().stream().map(IdentifiableData::getId).collect(Collectors.toList()));
		return data;
	}

	@Override
	public CourseEntity convertToEntity(CourseData data, CourseEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
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
		if (CollectionUtils.isNotEmpty(data.getStudentIds())) {
			if (entity.getStudents() == null) {
				entity.setStudents(new ArrayList<>());
			}
			data.getStudentIds().forEach(studentId -> entity.getStudents().add(userService.getStudentById(studentId)));
		}
		return entity;
	}
}
