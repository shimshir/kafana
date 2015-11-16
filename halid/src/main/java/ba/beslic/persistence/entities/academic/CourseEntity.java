package ba.beslic.persistence.entities.academic;

import ba.beslic.persistence.entities.IdentifiableEntity;

import javax.persistence.*;

import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.persistence.entities.academic.teacher.TeacherEntity;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "Course")
@Table(name = "course")
public class CourseEntity extends IdentifiableEntity {
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_2_teacher",
			  joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			  inverseJoinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id"))
	private List<TeacherEntity> teachers;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "course_2_student",
			  joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
			  inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
	private List<StudentEntity> students;

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

	public List<TeacherEntity> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
}
