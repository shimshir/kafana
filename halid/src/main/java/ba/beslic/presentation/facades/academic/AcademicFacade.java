package ba.beslic.presentation.facades.academic;

import ba.beslic.presentation.data.academic.CourseData;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface AcademicFacade {
	CourseData createCourse(CourseData courseData);

	CourseData getCourseById(int id);
}
