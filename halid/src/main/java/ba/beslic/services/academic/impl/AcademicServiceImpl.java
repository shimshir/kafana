package ba.beslic.services.academic.impl;

import ba.beslic.daos.academic.AcademicDao;
import ba.beslic.models.persistence.academic.CourseEntity;
import ba.beslic.services.academic.AcademicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Service("academicService")
public class AcademicServiceImpl implements AcademicService {
	@Autowired
	private AcademicDao academicDao;

	@Override
	public CourseEntity createCourse(CourseEntity courseEntity) {
		academicDao.create(courseEntity);
		return courseEntity;
	}

	@Override
	public CourseEntity getCourseById(Integer id) {
		return academicDao.getById(CourseEntity.class, id);
	}
}
