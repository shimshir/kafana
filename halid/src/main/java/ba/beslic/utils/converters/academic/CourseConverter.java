package ba.beslic.utils.converters.academic;

import ba.beslic.models.persistence.IdentifiableEntity;
import ba.beslic.models.persistence.academic.CourseEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.presentation.academic.CourseData;
import ba.beslic.utils.converters.IdentifiableConverter;
import ba.beslic.utils.converters.academic.student.StudentConverter;
import ba.beslic.services.user.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("courseConverter")
public class CourseConverter extends IdentifiableConverter<CourseEntity, CourseData> {
	@Autowired
	private UserService userService;

	@Override
	public CourseData convertToData(CourseEntity entity, CourseData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		// name
		data.setName(entity.getName());
		// code
		data.setCode(entity.getCode());
		// studentIds
		data.setStudentIds(entity.getStudents().stream().map(IdentifiableEntity::getId).collect(Collectors.toList()));
		// teacherIds
		data.setTeacherIds(entity.getTeachers().stream().map(IdentifiableEntity::getId).collect(Collectors.toList()));
		return data;
	}

	@Override
	public CourseEntity convertToEntity(CourseData data, CourseEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		// name
		entity.setName(data.getName());
		// code
		entity.setCode(data.getCode());
		// students
		if (CollectionUtils.isNotEmpty(data.getStudentIds())) {
			entity.setStudents(data.getStudentIds().stream().map(id -> userService.getStudentById(id)).collect(Collectors.toList()));
		}
		// teachers
		if (CollectionUtils.isNotEmpty(data.getTeacherIds())) {
			entity.setTeachers(data.getTeacherIds().stream().map(id -> userService.getTeacherById(id)).collect(Collectors.toList()));
		}
		return entity;
	}
}
