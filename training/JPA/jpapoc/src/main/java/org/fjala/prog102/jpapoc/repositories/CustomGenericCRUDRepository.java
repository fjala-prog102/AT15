package org.fjala.prog102.jpapoc.repositories;

import org.fjala.prog102.jpapoc.models.StudentModel;
import org.fjala.prog102.jpapoc.repositories.impl.CustomGenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomGenericCRUDRepository extends JpaRepository<StudentModel, Long>, CustomGenericRepository<StudentModel, Long> {
    
}
