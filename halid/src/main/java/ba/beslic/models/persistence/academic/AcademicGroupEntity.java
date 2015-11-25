package ba.beslic.models.persistence.academic;

import ba.beslic.models.persistence.IdentifiableEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    25.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "AcademicGroup")
@Table(name = "academic_group")
public class AcademicGroupEntity extends IdentifiableEntity {
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;
	@OneToMany(mappedBy = "academicGroup", cascade = CascadeType.ALL)
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

	public List<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
}
