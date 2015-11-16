package ba.beslic.facades.academic;

import ba.beslic.models.presentation.academic.CourseData;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface AcademicFacade {
	CourseData createCourse(CourseData courseData);

	CourseData getCourseById(Integer id);
}
