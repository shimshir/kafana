package ba.beslic.services.academic;

import ba.beslic.models.persistence.academic.AcademicGroupEntity;
import ba.beslic.models.persistence.academic.CourseEntity;
import ba.beslic.models.persistence.academic.ScoreEntity;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface AcademicService {
	CourseEntity createCourse(CourseEntity courseEntity);
	CourseEntity getCourseById(Integer id);
	AcademicGroupEntity getAcademicGroupById(Integer id);
	ScoreEntity getScoreById(Integer id);
}
