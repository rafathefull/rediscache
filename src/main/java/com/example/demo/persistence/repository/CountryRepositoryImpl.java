package com.example.demo.persistence.repository;

import com.example.demo.persistence.domain.Country;
import com.example.demo.persistence.domain.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Country getCode(String code) {
        String jpaQuery = "SELECT e FROM Country e WHERE e.code = :code ";

        return entityManager.createQuery(jpaQuery, Country.class)
                .setParameter("code", code)
                .getSingleResult();
    }

    @Override
    public List<Country> listAll() {
        String jpaQuery = "SELECT e FROM Country e";

        return entityManager.createQuery(jpaQuery, Country.class)
                .getResultList();
    }
}
