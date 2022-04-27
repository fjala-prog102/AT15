package org.fjala.prog102.jpapoc.repositories.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomGenericRepositoryImpl<E, ID> implements CustomGenericRepository<E, ID> {

    //private final Class<E> clazz;

    @PersistenceContext
    private EntityManager entityManager;

    /*public CustomGenericRepositoryImpl(Class<E> clazz){
        this.clazz = clazz;
     }*/

    @Override
    public E customFindById(ID id) {
        // TODO: Fix how to get the entity name
        String entityName = "StudentModel";
        return (E) entityManager.createQuery("SELECT e FROM " + entityName + " AS e WHERE e.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }
    
}
