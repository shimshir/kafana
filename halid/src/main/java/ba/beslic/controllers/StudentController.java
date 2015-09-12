package ba.beslic.controllers;

import ba.beslic.persistence.models.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Admir Memić
 * Date:   16.08.2015
 */

@RestController
@RequestMapping("/students")
public class StudentController
{

	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Admir", "Memic"));
		students.add(new Student("Merry", "Fizzlebomb"));
		students.add(new Student("Whimsy", "Scribbler"));
		students.add(new Student("Dippery", "Gollywock"));
		students.add(new Student("Breaddystack", "Spleggings"));
		return students;
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable String studentId)
	{
		return new Student("Wunderbah", "Wellington");
	}
}
