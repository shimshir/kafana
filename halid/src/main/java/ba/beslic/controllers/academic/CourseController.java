package ba.beslic.controllers.academic;

import ba.beslic.models.presentation.academic.CourseData;
import ba.beslic.facades.academic.AcademicFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseData> getCourseById(@PathVariable int id) {
		return ResponseEntity.ok(academicFacade.getCourseById(id));
	}
}
