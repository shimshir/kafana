package ba.beslic.persistence.entities.academic.teacher;

import ba.beslic.persistence.entities.academic.CourseEntity;
import ba.beslic.persistence.entities.user.UserEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "Teacher")
public class TeacherEntity extends UserEntity {
	@Column(name = "title")
	private String title;
	@ManyToMany(mappedBy = "teachers")
	private List<CourseEntity> courses;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}
}
