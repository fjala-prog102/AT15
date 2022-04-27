package org.fjala.prog102.jpapoc.repositories;

import org.fjala.prog102.jpapoc.models.StudentModel;
import org.fjala.prog102.jpapoc.repositories.impl.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomCRUDRepository extends JpaRepository<StudentModel, Long>, CustomRepository {

}
