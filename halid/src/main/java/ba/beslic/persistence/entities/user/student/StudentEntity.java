package ba.beslic.persistence.entities.user.student;

import ba.beslic.persistence.entities.user.UserEntity;

import javax.persistence.*;
import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    27.09.15
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "Student")
public class StudentEntity extends UserEntity {
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_2_score",
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "score_id", referencedColumnName = "id"))
	private List<ScoreEntity> scores;


	public List<ScoreEntity> getScores() {
		return scores;
	}

	public void setScores(List<ScoreEntity> scores) {
		this.scores = scores;
	}
}
