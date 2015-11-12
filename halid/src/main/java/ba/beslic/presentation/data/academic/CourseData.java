package ba.beslic.presentation.data.academic;

import ba.beslic.presentation.data.PresentationData;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.presentation.data.academic.teacher.TeacherData;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class CourseData implements PresentationData {
	private String code;
	private String name;
	private List<StudentData> students;
	private List<TeacherData> teachers;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentData> getStudents() {
		return students;
	}

	public void setStudents(List<StudentData> students) {
		this.students = students;
	}

	public List<TeacherData> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherData> teachers) {
		this.teachers = teachers;
	}
}
