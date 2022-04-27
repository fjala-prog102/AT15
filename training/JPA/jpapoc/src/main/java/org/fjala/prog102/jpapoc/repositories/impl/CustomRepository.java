package org.fjala.prog102.jpapoc.repositories.impl;

import org.fjala.prog102.jpapoc.exceptions.NotFoundException;
import org.fjala.prog102.jpapoc.models.StudentModel;

public interface CustomRepository {
    StudentModel customSave(StudentModel s);
    StudentModel customFindById(Long id) throws NotFoundException;
    void customRemove(StudentModel s);
}
