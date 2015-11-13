package ba.beslic.service.services.academic.impl;

import ba.beslic.persistence.daos.academic.AcademicDao;
import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.service.services.academic.AcademicService;
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
}
