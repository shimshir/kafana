package ba.beslic.service.services.user.impl;

import ba.beslic.persistence.daos.user.UserDao;
import ba.beslic.persistence.entities.user.UserEntity;
import ba.beslic.persistence.entities.user.student.StudentEntity;
import ba.beslic.presentation.data.user.student.StudentData;
import ba.beslic.service.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public UserEntity getUserById(int id) {
		return userDao.getById(UserEntity.class, id);
	}

	@Override
	public void createStudent(StudentEntity studentEntity) {
		userDao.create(studentEntity);
	}

	@Override
	public StudentEntity getStudentById(int id) {
		return userDao.getById(StudentEntity.class, id);
	}
}
