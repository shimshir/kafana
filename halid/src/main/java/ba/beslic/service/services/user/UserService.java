package ba.beslic.service.services.user;

import ba.beslic.persistence.entities.user.UserEntity;
import ba.beslic.persistence.entities.academic.student.StudentEntity;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserService {
	UserEntity getUserById(int id);

	StudentEntity createStudent(StudentEntity studentEntity);

	StudentEntity getStudentById(int id);
}
