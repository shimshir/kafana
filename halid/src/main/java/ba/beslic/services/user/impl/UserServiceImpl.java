package ba.beslic.services.user.impl;

import ba.beslic.daos.user.UserDao;
import ba.beslic.models.persistence.user.AccountEntity;
import ba.beslic.models.persistence.user.UUIDTokenEntity;
import ba.beslic.models.persistence.user.UserEntity;
import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.persistence.user.UserSessionEntity;
import ba.beslic.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:  Admir Memic
 * Date:    11.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserEntity getUserById(Integer id) {
		return userDao.getById(UserEntity.class, id);
	}

	@Override
	public StudentEntity createStudent(StudentEntity studentEntity) {
		userDao.create(studentEntity);
		return studentEntity;
	}

	@Override
	public StudentEntity getStudentById(Integer id) {
		return userDao.getById(StudentEntity.class, id);
	}

	@Override
	public AccountEntity getAccountByUsername(String username) {
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		return userDao.findUnique(AccountEntity.class, params);
	}

	@Override
	public UserSessionEntity createUserSession(UserEntity user) {
		UserSessionEntity userSessionEntity = new UserSessionEntity();
		userSessionEntity.setUser(user);
		userSessionEntity.setUuidToken(new UUIDTokenEntity());
		userSessionEntity.setActive(true);
		userDao.create(userSessionEntity);
		return userSessionEntity;
	}

	@Override
	public UserSessionEntity getUserSessionByUUID(UUIDTokenEntity uuidToken) {
		Map<String, Object> params = new HashMap<>();
		params.put("uuidToken", uuidToken);
		return userDao.findUnique(UserSessionEntity.class, params);
	}

	@Override
	public UUIDTokenEntity getUUIDTokenById(String uuid) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", uuid);
		return userDao.findUnique(UUIDTokenEntity.class, params);
	}
}
