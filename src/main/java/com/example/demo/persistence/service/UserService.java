package com.example.demo.persistence.service;

import com.example.demo.persistence.domain.User;

public interface UserService {

    User getById(Integer userId);

    void delete(User user);

    User save(User user);
}
