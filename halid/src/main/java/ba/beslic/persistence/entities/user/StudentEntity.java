package ba.beslic.persistence.entities.user;

import ba.beslic.persistence.entities.ScoreEntity;

import javax.persistence.*;
import java.util.Set;

/**
 * Author:  Admir Memic
 * Date:    27.09.15
 * E-Mail:  admir.memic@dmc.de
 */
@Entity(name = "Student")
@Table(name = "student")
public class StudentEntity extends UserEntity {
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_2_score",
			joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "score_id", referencedColumnName = "id"))
	private Set<ScoreEntity> scores;


	public Set<ScoreEntity> getScores() {
		return scores;
	}

	public void setScores(Set<ScoreEntity> scores) {
		this.scores = scores;
	}
}
