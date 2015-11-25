package ba.beslic.models.persistence.academic.student;

import ba.beslic.models.persistence.academic.CourseEntity;
import ba.beslic.models.persistence.academic.AcademicGroupEntity;
import ba.beslic.models.persistence.academic.ScoreEntity;
import ba.beslic.models.persistence.user.UserEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    27.09.15
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "Student")
public class StudentEntity extends UserEntity {

	@Column(name = "card_code")
	private String cardCode;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ScoreEntity> scores;
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	private List<CourseEntity> courses;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "academic_group_id")
	private AcademicGroupEntity academicGroup;

	public List<ScoreEntity> getScores() {
		return scores;
	}

	public void setScores(List<ScoreEntity> scores) {
		this.scores = scores;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	public AcademicGroupEntity getAcademicGroup() {
		return academicGroup;
	}

	public void setAcademicGroup(AcademicGroupEntity academicGroup) {
		this.academicGroup = academicGroup;
	}
}
