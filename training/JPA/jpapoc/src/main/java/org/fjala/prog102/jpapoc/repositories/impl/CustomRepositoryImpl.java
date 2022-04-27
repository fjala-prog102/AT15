package org.fjala.prog102.jpapoc.repositories.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.fjala.prog102.jpapoc.exceptions.NotFoundException;
import org.fjala.prog102.jpapoc.models.StudentModel;

@Transactional
public class CustomRepositoryImpl implements CustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StudentModel customSave(StudentModel s) {
        // org.springframework.dao.InvalidDataAccessApiUsageException: Not allowed to create transaction on shared EntityManager - use Spring transactions or EJB CMT instead
        //entityManager.getTransaction().begin();
        entityManager.persist(s);
        //entityManager.getTransaction().commit();
        return s;
    }

    @Override
    public StudentModel customFindById(Long id) throws NotFoundException {
        try{
            return (StudentModel) entityManager.createQuery("SELECT s FROM StudentModel AS s WHERE s.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        } catch (Throwable e) {
            throw new NotFoundException("", e);
        }
    }

    @Override
    public void customRemove(StudentModel s) {
        entityManager.remove(s);
    }

}
