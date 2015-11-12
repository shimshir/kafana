package ba.beslic.presentation.data.academic.student;

import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.user.UserData;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class StudentData extends UserData {

	private String cardCode;
	private List<ScoreData> scores;
	private List<CourseData> courses;

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public List<ScoreData> getScores() {
		return scores;
	}

	public void setScores(List<ScoreData> scores) {
		this.scores = scores;
	}

	public List<CourseData> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseData> courses) {
		this.courses = courses;
	}
}
