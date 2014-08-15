package com.github.kindrat.liquidfeedback.api.persistence.dao;

import com.github.kindrat.liquidfeedback.api.persistence.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

abstract class AbstractJpaDao<ENTITY extends BaseEntity> {
    private Class<ENTITY> clazz;

    @Autowired
    private EntityManager entityManager;

    public void setClazz(Class<ENTITY> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public ENTITY find(Long id) {
        return entityManager.find(this.clazz, id);
    }

    public List<ENTITY> findAll() {
        return entityManager.createQuery("from " + clazz.getName(), clazz).getResultList();
    }

    public ENTITY save(ENTITY entity) {
        begin();
        entityManager.persist(entity);
        return entity;
    }

    public void update(ENTITY entity) {
        begin();
        entityManager.merge(entity);
    }

    public void delete(ENTITY entity) {
        begin();
        entityManager.remove(entity);
    }

    public void deleteById(Long entityId) {
        ENTITY entity = find(entityId);
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
