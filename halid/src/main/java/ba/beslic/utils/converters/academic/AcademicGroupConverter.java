package ba.beslic.utils.converters.academic;

import ba.beslic.models.persistence.IdentifiableEntity;
import ba.beslic.models.persistence.academic.AcademicGroupEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.presentation.academic.AcademicGroupData;
import ba.beslic.models.presentation.academic.student.StudentData;
import ba.beslic.services.user.UserService;
import ba.beslic.utils.converters.IdentifiableConverter;
import ba.beslic.utils.converters.academic.student.StudentConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    25.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("academicGroupConverter")
public class AcademicGroupConverter  extends IdentifiableConverter<AcademicGroupEntity, AcademicGroupData> {
	@Autowired
	private UserService userService;

	@Override
	public AcademicGroupData convertToData(AcademicGroupEntity entity, AcademicGroupData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		// code
		data.setCode(entity.getCode());
		// name
		data.setName(entity.getName());
		// studentsIds
		if (CollectionUtils.isNotEmpty(entity.getStudents())) {
			data.setStudentIds(entity.getStudents().stream().map(IdentifiableEntity::getId).collect(Collectors.toList()));
		}
		return data;
	}

	@Override
	public AcademicGroupEntity convertToEntity(AcademicGroupData data, AcademicGroupEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		// code
		entity.setCode(data.getCode());
		// name
		entity.setName(data.getName());
		// students
		if (CollectionUtils.isNotEmpty(data.getStudentIds())) {
			entity.setStudents(data.getStudentIds().stream().map(id -> userService.getStudentById(id)).collect(Collectors.toList()));
		}
		return entity;
	}
}
