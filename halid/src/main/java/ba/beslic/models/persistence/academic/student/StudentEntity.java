package ba.beslic.models.persistence.academic.student;

import ba.beslic.models.persistence.academic.CourseEntity;
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
	@JoinTable(
			name = "student_2_score",
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "score_id", referencedColumnName = "id"))
	private List<ScoreEntity> scores;
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	private List<CourseEntity> courses;

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
}
