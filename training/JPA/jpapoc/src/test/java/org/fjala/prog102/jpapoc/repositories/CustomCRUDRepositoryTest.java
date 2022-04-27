package org.fjala.prog102.jpapoc.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.fjala.prog102.jpapoc.exceptions.NotFoundException;
import org.fjala.prog102.jpapoc.models.StudentModel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CustomCRUDRepositoryTest {

	Logger logger = LoggerFactory.getLogger(CustomCRUDRepositoryTest.class);

	@Autowired
	private CustomCRUDRepository crudRepository;

	@Test
	public void customSaveTest() {
		StudentModel student = new StudentModel();
		student.setFirstName("Woody");
		student.setLastName("Woodpecker");

		StudentModel persistedStudent = crudRepository.customSave(student);

		System.out.println("Student created: " + persistedStudent.getId() + " " + persistedStudent.getFirstName() + " "
				+ persistedStudent.getLastName());
		logger.info("Student created: {} {} {}", persistedStudent.getId(), persistedStudent.getFirstName(), persistedStudent.getLastName());
		assertEquals(student.getFirstName(), persistedStudent.getFirstName(), "First names do not match!");
		assertEquals(student.getLastName(), persistedStudent.getLastName(), "Last names do not match!");
		assertTrue(persistedStudent.getId() != null, "A created entity should have it's id different than null");
		assertTrue(persistedStudent.getId() != 0, "A created entity should have it's id different than 0");
		// FIXME: not null really
		//assertNull(student.getId(), "The id of the original object is null");
		assertEquals(persistedStudent.getId(), 1L);
	}

	@Test
	public void customFindTest() {
		StudentModel student = new StudentModel();
		student.setFirstName("Joe");
		student.setLastName("Cool");

		StudentModel persistedStudent = crudRepository.save(student);

		StudentModel studentFound = null;
		try {
			studentFound = crudRepository.customFindById(persistedStudent.getId());
		} catch (NotFoundException e) {
			System.out.println("Unexpected!");
			System.exit(1);
		}
		
		System.out.println("Student found: " + studentFound.getId() + " " + studentFound.getFirstName() + " "
				+ studentFound.getLastName());
		logger.info("Student found: {} {} {}", studentFound.getId(), studentFound.getFirstName(), studentFound.getLastName());
		assertEquals(persistedStudent.getId(), studentFound.getId(), "Ids do not match!");
	}

	@Test
	public void customRemove() {
		StudentModel student = new StudentModel();
		student.setFirstName("Joe");
		student.setLastName("Cool");

		StudentModel persistedStudent = crudRepository.save(student);

		crudRepository.customRemove(persistedStudent);
		// Throws: NoResultException
		assertThrows(NotFoundException.class, () -> {
			crudRepository.customFindById(persistedStudent.getId());
		});
	}
}
