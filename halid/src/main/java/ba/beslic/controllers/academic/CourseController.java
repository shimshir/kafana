package ba.beslic.controllers.academic;

import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.facades.academic.AcademicFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:  Admir Memic
 * Date:    13.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private AcademicFacade academicFacade;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CourseData> createCourse(@RequestBody CourseData course) {
		return ResponseEntity.ok(academicFacade.createCourse(course));
	}
}
