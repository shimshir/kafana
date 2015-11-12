package ba.beslic.presentation.facades.user.impl;

import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.presentation.facades.user.UserFacade;
import ba.beslic.service.converters.academic.student.StudentConverter;
import ba.beslic.service.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public void createStudent(StudentData studentData) {
		userService.createStudent(studentConverter.convertToEntity(studentData, new StudentEntity()));
	}

	@Override
	public StudentData getStudentById(int id) {
		return studentConverter.convertToData(userService.getStudentById(id), new StudentData());
	}
}
