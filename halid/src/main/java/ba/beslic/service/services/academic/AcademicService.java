package ba.beslic.service.services.academic;

import ba.beslic.persistence.entities.academic.CourseEntity;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface AcademicService {
	CourseEntity createCourse(CourseEntity courseEntity);
}
