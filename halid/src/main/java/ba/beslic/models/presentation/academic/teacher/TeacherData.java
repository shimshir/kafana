package ba.beslic.models.presentation.academic.teacher;

import ba.beslic.models.presentation.academic.CourseData;
import ba.beslic.models.presentation.user.UserData;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class TeacherData extends UserData {
	private String title;
	private List<CourseData> courses;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CourseData> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseData> courses) {
		this.courses = courses;
	}
}
