package ba.beslic.facades.user;

import ba.beslic.models.presentation.academic.student.StudentData;
import ba.beslic.models.presentation.user.CredentialsData;
import ba.beslic.models.presentation.user.UserSessionData;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserFacade {
	StudentData createStudent(StudentData studentData);
	StudentData getStudentById(Integer id);
	List<StudentData> getAllStudents();

	UserSessionData createSession(CredentialsData credentials);

	UserSessionData getUserSessionByUUID(String uuid);
}
