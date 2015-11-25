package ba.beslic.models.presentation.academic;

import ba.beslic.models.presentation.IdentifiableData;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    25.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class AcademicGroupData extends IdentifiableData {
	private String code;
	private String name;
	private List<Integer> studentIds;

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

	public List<Integer> getStudentIds() {
		return studentIds;
	}

	public void setStudentIds(List<Integer> studentIds) {
		this.studentIds = studentIds;
	}
}
