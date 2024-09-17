package com.example.demo.persistence.repository;

import com.example.demo.persistence.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User getById(Integer userId) {
        String jpaQuery = "SELECT e FROM User e WHERE e.id = :userId ";

        return entityManager.createQuery(jpaQuery, User.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    @Override
    public void delete(User user) {
        // TODO: Implement this method.
        // entityManager.remove(user);
        // A efectos prácticos, lo que queremos es ver que la cache se invalida cuando se elimina un usuario.
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }
}
