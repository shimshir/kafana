package ba.beslic.utils.converters.academic.student;

import ba.beslic.models.persistence.IdentifiableEntity;
import ba.beslic.models.persistence.academic.AcademicGroupEntity;
import ba.beslic.models.persistence.academic.CourseEntity;
import ba.beslic.models.persistence.academic.ScoreEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.presentation.IdentifiableData;
import ba.beslic.models.presentation.academic.AcademicGroupData;
import ba.beslic.models.presentation.academic.CourseData;
import ba.beslic.models.presentation.academic.student.ScoreData;
import ba.beslic.models.presentation.academic.student.StudentData;
import ba.beslic.utils.converters.academic.AcademicGroupConverter;
import ba.beslic.utils.converters.academic.CourseConverter;
import ba.beslic.utils.converters.user.UserConverter;
import ba.beslic.services.academic.AcademicService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
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
	private AcademicGroupConverter academicGroupConverter;
	@Autowired
	private AcademicService academicService;

	@Override
	public StudentData convertToData(StudentEntity entity, StudentData data) {
		if (entity == null)
			return null;
		super.convertToData(entity, data);
		// cardCode
		data.setCardCode(entity.getCardCode());
		// scoreIds
		if (CollectionUtils.isNotEmpty(entity.getScores())) {
			data.setScoreIds(entity.getScores().stream().map(IdentifiableEntity::getId).collect(Collectors.toList()));
		}
		// courseIds
		if (CollectionUtils.isNotEmpty(entity.getCourses())) {
			data.setCourseIds(entity.getCourses().stream().map(IdentifiableEntity::getId).collect(Collectors.toList()));
		}
		// academicGroup
		if (entity.getAcademicGroup() != null) {
			// object
			data.setAcademicGroup(academicGroupConverter.convertToData(entity.getAcademicGroup(), new AcademicGroupData()));
			// id
			data.setAcademicGroupId(entity.getAcademicGroup().getId());
		}
		return data;
	}

	@Override
	public StudentEntity convertToEntity(StudentData data, StudentEntity entity) {
		if (data == null)
			return null;
		super.convertToEntity(data, entity);
		// cardCode
		entity.setCardCode(data.getCardCode());
		// scores
		if (CollectionUtils.isNotEmpty(data.getScoreIds())) {
			entity.setScores(data.getScoreIds().stream().map(id -> academicService.getScoreById(id)).collect(Collectors.toList()));
		}
		// courses
		if (CollectionUtils.isNotEmpty(data.getCourseIds())) {
			entity.setScores(data.getScoreIds().stream().map(id -> academicService.getScoreById(id)).collect(Collectors.toList()));
		}
		// academicGroup
		if (data.getAcademicGroup() != null && data.getAcademicGroupId() == null) {
			entity.setAcademicGroup(academicGroupConverter.convertToEntity(data.getAcademicGroup(), new AcademicGroupEntity()));
		} else if (data.getAcademicGroup() == null && data.getAcademicGroupId() != null) {
			entity.setAcademicGroup(academicService.getAcademicGroupById(data.getAcademicGroupId()));
		} else if (data.getAcademicGroup() != null && data.getAcademicGroupId() != null) {
			throw new UnsupportedOperationException("Ambiguous academicGroup!");
		}
		return entity;
	}
}
