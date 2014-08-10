package com.github.kindrat.liquidfeedback.api.persistence.dao;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

abstract class AbstractJpaDao<T extends Serializable> {
    private Class<T> clazz;
    private final EntityManager entityManager;

    public AbstractJpaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T find(Long id) {
        return entityManager.find(this.clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return (List<T>) entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public T save(T entity) {
        begin();
        entityManager.persist(entity);
        return entity;
    }

    public void update(T entity) {
        begin();
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        begin();
        entityManager.remove(entity);
    }

    public void deleteById(Long entityId) {
        T entity = find(entityId);
        delete(entity);
    }

    public void begin() {
        if (!entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().begin();
        }
    }

    public void commit() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().commit();
        }
    }

    public void revert() {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
