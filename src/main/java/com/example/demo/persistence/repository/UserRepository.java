package com.example.demo.persistence.repository;

import com.example.demo.persistence.domain.User;

public interface UserRepository {

    User getById(Integer userId);

    void delete(User user);

    User save(User user);
}