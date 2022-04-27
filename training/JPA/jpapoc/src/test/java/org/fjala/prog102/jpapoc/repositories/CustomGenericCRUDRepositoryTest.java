package org.fjala.prog102.jpapoc.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fjala.prog102.jpapoc.models.StudentModel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CustomGenericCRUDRepositoryTest {

	Logger logger = LoggerFactory.getLogger(CustomGenericCRUDRepositoryTest.class);

	@Autowired
	private CustomGenericCRUDRepository crudRepository;

	@Test
	public void findTest() {
		StudentModel student = new StudentModel();
		student.setFirstName("Joe");
		student.setLastName("Cool");

		StudentModel persistedStudent = crudRepository.save(student);

		StudentModel studentFound = crudRepository.customFindById(persistedStudent.getId());
		System.out.println("Student found: " + studentFound.getId() + " " + studentFound.getFirstName() + " "
				+ studentFound.getLastName());
		logger.info("Student found: {} {} {}", studentFound.getId(), studentFound.getFirstName(), studentFound.getLastName());
		assertEquals(persistedStudent.getId(), studentFound.getId(), "Ids do not match!");
	}

}
