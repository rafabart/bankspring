package com.invillia.bankspring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Component
public abstract class GenericDao<T, I extends Serializable> {

    @Autowired
    private EntityManager entityManager;

    private Class<T> persistedClass;

    protected GenericDao() {
    }

    protected GenericDao(Class<T> persistedClass) {
        this.persistedClass = persistedClass;
    }

    public void insert(T entity) {

        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(entity);
        transaction.commit();
    }

    public void update(T entity) {

        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.merge(entity);
        transaction.commit();
    }

    public void deleteById(I id) {

        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Optional<T> entity = findById(id);
        if (entity.isPresent()) {
            entityManager.remove(entity.get());
        } else {
            System.err.println(persistedClass.getSimpleName() + " not find!");
        }
        transaction.commit();
    }

    public List<T> findAll() {

        final TypedQuery<T> person = entityManager.createQuery(
                "FROM " + persistedClass.getSimpleName(),
                persistedClass
        );
        return person.getResultList();
    }

    public Optional<T> findById(I id) {
        return Optional.of(entityManager.find(persistedClass, id));
    }
}
