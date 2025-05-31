package io.learnstuff.jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@EnableTransactionManagement
public abstract class AbstractDAO<E> {

    @PersistenceContext
    private EntityManager em;

    private final Class<E> entityClass;

    protected AbstractDAO(final Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public EntityManager em() {
        return em;
    }

    @Transactional
    public E findById(final Long entityId) {
        return em.find(entityClass, entityId);
    }

    @Transactional
    public void save(final E entityToBeSaved) {
        em.persist(entityToBeSaved);
    }

    @Transactional
    public void update(final E entityToBeUpdated) {
        em.merge(entityToBeUpdated);
    }

    @Transactional
    public void remove(final E entityToBeRemoved) {
        em.remove(entityToBeRemoved);
    }

    @Transactional
    public void delete(final Long id) {
        em.remove(findById(id));
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<E> findAll() {
        return (List<E>) em.createQuery(new StringBuilder().append("SELECT entity FROM ")
                .append(entityClass.getCanonicalName()).append(" entity ").toString()).getResultList();
    }

}
