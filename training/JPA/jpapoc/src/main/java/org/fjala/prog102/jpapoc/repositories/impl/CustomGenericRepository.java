package org.fjala.prog102.jpapoc.repositories.impl;

public interface CustomGenericRepository<E, ID> {
    E customFindById(ID id);
}
