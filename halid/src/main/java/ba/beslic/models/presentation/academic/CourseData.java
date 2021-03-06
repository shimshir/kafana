package ba.beslic.models.presentation.academic;

import ba.beslic.models.presentation.IdentifiableData;
import ba.beslic.models.presentation.academic.student.StudentData;
import ba.beslic.models.presentation.academic.teacher.TeacherData;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public class CourseData extends IdentifiableData {
	private String code;
	private String name;
	private List<Integer> studentIds;
	private List<Integer> teacherIds;

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

	public List<Integer> getTeacherIds() {
		return teacherIds;
	}

	public void setTeacherIds(List<Integer> teacherIds) {
		this.teacherIds = teacherIds;
	}
}
