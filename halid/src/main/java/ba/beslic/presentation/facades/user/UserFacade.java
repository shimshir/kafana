package ba.beslic.presentation.facades.user;

import ba.beslic.presentation.data.user.student.StudentData;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserFacade {
	void createStudent(StudentData studentData);
	StudentData getStudentById(int id);
}
