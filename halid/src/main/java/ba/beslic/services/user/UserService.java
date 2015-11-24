package ba.beslic.services.user;

import ba.beslic.models.persistence.user.AccountEntity;
import ba.beslic.models.persistence.user.UUIDTokenEntity;
import ba.beslic.models.persistence.user.UserEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.persistence.user.UserSessionEntity;
import ba.beslic.models.presentation.user.UserSessionData;

import java.util.List;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
public interface UserService {
	UserEntity getUserById(Integer id);

	StudentEntity createStudent(StudentEntity studentEntity);

	StudentEntity getStudentById(Integer id);

	AccountEntity getAccountByUsername(String username);

	UserSessionEntity createUserSession(UserEntity user);

	UserSessionEntity getUserSessionByUUID(UUIDTokenEntity uuidToken);

	UUIDTokenEntity getUUIDTokenById(String uuid);

	List<StudentEntity> getAllStudents();
}
