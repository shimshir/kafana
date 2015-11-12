package ba.beslic.service.services.user;

import ba.beslic.persistence.entities.user.UserEntity;
import ba.beslic.persistence.entities.user.student.StudentEntity;
import ba.beslic.presentation.data.user.student.StudentData;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserService {
	UserEntity getUserById(int id);

	void createStudent(StudentEntity studentEntity);

	StudentEntity getStudentById(int id);
}
