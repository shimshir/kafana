package ba.beslic.presentation.facades.user.impl;

import ba.beslic.persistence.entities.academic.student.StudentEntity;
import ba.beslic.presentation.data.academic.student.StudentData;
import ba.beslic.presentation.facades.user.UserFacade;
import ba.beslic.service.converters.academic.student.NewStudentConverter;
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
	private NewStudentConverter studentConverter;
	@Autowired
	private UserService userService;

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
	public StudentData getStudentById(int id) {
		StudentEntity studentEntity = userService.getStudentById(id);
		return studentConverter.convertToData(studentEntity, new StudentData());
	}
}
