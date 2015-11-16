package ba.beslic.presentation.data.academic.student;

import ba.beslic.presentation.data.IdentifiableData;
import ba.beslic.presentation.data.academic.CourseData;
import ba.beslic.presentation.data.user.UserData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

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
