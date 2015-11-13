package ba.beslic.controllers.academic.student;

import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.presentation.facades.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<StudentData> createStudent(@RequestBody StudentData student) {
		return ResponseEntity.ok(userFacade.createStudent(student));
	}

	@RequestMapping(path= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentData> getStudentById(@PathVariable int id) {
		return ResponseEntity.ok(userFacade.getStudentById(id));
	}
}
