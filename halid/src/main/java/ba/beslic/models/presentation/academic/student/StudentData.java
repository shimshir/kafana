package ba.beslic.models.presentation.academic.student;

import ba.beslic.models.presentation.academic.AcademicGroupData;
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
	private List<Integer> scoreIds;
	private List<Integer> courseIds;
	private AcademicGroupData academicGroup;
	private Integer academicGroupId;

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public List<Integer> getScoreIds() {
		return scoreIds;
	}

	public void setScoreIds(List<Integer> scoreIds) {
		this.scoreIds = scoreIds;
	}

	public List<Integer> getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(List<Integer> courseIds) {
		this.courseIds = courseIds;
	}

	@JsonIgnore
	public AcademicGroupData getAcademicGroup() {
		return academicGroup;
	}

	@JsonProperty
	public void setAcademicGroup(AcademicGroupData academicGroup) {
		this.academicGroup = academicGroup;
	}

	public Integer getAcademicGroupId() {
		return academicGroupId;
	}

	public void setAcademicGroupId(Integer academicGroupId) {
		this.academicGroupId = academicGroupId;
	}
}
