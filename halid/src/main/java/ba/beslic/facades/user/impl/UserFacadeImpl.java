package ba.beslic.facades.user.impl;

import ba.beslic.models.persistence.academic.student.StudentEntity;
import ba.beslic.models.persistence.user.AccountEntity;
import ba.beslic.models.persistence.user.UUIDTokenEntity;
import ba.beslic.models.persistence.user.UserSessionEntity;
import ba.beslic.models.presentation.academic.student.StudentData;
import ba.beslic.models.presentation.user.AccountData;
import ba.beslic.models.presentation.user.CredentialsData;
import ba.beslic.models.presentation.user.UserSessionData;
import ba.beslic.facades.user.UserFacade;
import ba.beslic.utils.converters.academic.student.StudentConverter;
import ba.beslic.services.user.UserService;
import ba.beslic.utils.converters.user.AccountConverter;
import ba.beslic.utils.converters.user.UserSessionConverter;
import ba.beslic.utils.security.PasswordEncoderWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author:  Admir Memic
 * Date:    12.11.2015
 * E-Mail:  admir.memic@dmc.de
 */
@Component("userFacade")
@Transactional
public class UserFacadeImpl implements UserFacade {

	@Autowired
	private StudentConverter studentConverter;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoderWrapper passwordEncoder;
	@Autowired
	private UserSessionConverter userSessionConverter;
	@Autowired
	private AccountConverter accountConverter;

	@Override
	public StudentData createStudent(StudentData studentData) {
		// Convert to Entity object
		StudentEntity studentEntity = studentConverter.convertToEntity(studentData, new StudentEntity());
		// Save it to the DB, gets mutated
		userService.createStudent(studentEntity);
		// Create and return newly populated Data object
		return studentConverter.convertToData(studentEntity, new StudentData());
	}

	@Override
	public StudentData getStudentById(Integer id) {
		StudentEntity studentEntity = userService.getStudentById(id);
		return studentConverter.convertToData(studentEntity, new StudentData());
	}

	@Override
	public List<StudentData> getAllStudents() {
		List<StudentEntity> studentEntities = userService.getAllStudents();
		return studentEntities.stream().map(studentEntity ->
				studentConverter.convertToData(studentEntity, new StudentData())).collect(Collectors.toList());
	}

	@Override
	public UserSessionData createSession(CredentialsData credentials) {

		AccountEntity accountEntity = userService.getAccountByUsername(credentials.getUsername());
		if (passwordEncoder.encode(credentials.getUsername(), credentials.getPassword())
				.equals(accountEntity.getHashedPassword())) {
			return userSessionConverter.convertToData(
					userService.createUserSession(accountEntity.getUser()), new UserSessionData());
		} else
			throw new AuthenticationCredentialsNotFoundException("Wrong login data!");
	}

	@Override
	public UserSessionData getUserSessionByUUID(String uuid) {
		UUIDTokenEntity uuidTokenEntity = userService.getUUIDTokenById(uuid);
		UserSessionEntity userSessionEntity = userService.getUserSessionByUUID(uuidTokenEntity);
		return userSessionEntity == null ? null : userSessionConverter.convertToData(userSessionEntity, new UserSessionData());
	}

	@Override
	public AccountData getAccountById(Integer id) {
		return accountConverter.convertToData(userService.getAccountById(id), new AccountData());
	}
}
