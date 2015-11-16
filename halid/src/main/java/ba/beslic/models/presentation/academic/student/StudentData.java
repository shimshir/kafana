package ba.beslic.models.presentation.academic.student;

import ba.beslic.models.presentation.academic.CourseData;
import ba.beslic.models.presentation.user.UserData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private List<Integer> courseIds;

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

	@JsonIgnore
	public List<CourseData> getCourses() {
		return courses;
	}

	@JsonProperty
	public void setCourses(List<CourseData> courses) {
		this.courses = courses;
	}

	public List<Integer> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(List<Integer> courseIds) {
		this.courseIds = courseIds;
	}
}
