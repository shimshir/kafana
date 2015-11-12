package ba.beslic.presentation.data.academic.teacher;

import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.user.UserData;

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
