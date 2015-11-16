package ba.beslic.presentation.facades.academic.impl;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.facades.academic.AcademicFacade;
import ba.beslic.service.converters.academic.CourseConverter;
import ba.beslic.service.services.academic.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("academicFacade")
@Transactional
public class AcademicFacadeImpl implements AcademicFacade {
	@Autowired
	private AcademicService academicService;
	@Autowired
	private CourseConverter courseConverter;

	@Override
	public CourseData createCourse(CourseData courseData) {
		CourseEntity courseEntity = courseConverter.convertToEntity(courseData, new CourseEntity());
		academicService.createCourse(courseEntity);
		return courseConverter.convertToData(courseEntity, new CourseData());
	}

	@Override
	public CourseData getCourseById(int id) {
		return courseConverter.convertToData(academicService.getCourseById(id), new CourseData());
	}
}
