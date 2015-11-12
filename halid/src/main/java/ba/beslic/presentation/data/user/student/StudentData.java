package ba.beslic.presentation.data.user.student;

import ba.beslic.presentation.data.user.UserData;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class StudentData extends UserData {

	private List<ScoreData> scores;

	public List<ScoreData> getScores() {
		return scores;
	}

	public void setScores(List<ScoreData> scores) {
		this.scores = scores;
	}
}
