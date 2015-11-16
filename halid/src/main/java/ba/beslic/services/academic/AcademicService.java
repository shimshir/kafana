package ba.beslic.services.academic;

import ba.beslic.models.persistence.academic.CourseEntity;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface AcademicService {
	CourseEntity createCourse(CourseEntity courseEntity);
	CourseEntity getCourseById(Integer id);
}
