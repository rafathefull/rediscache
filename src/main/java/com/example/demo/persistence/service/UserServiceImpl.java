package com.example.demo.persistence.service;

import com.example.demo.config.CacheConfig;
import com.example.demo.persistence.repository.UserRepository;
import com.example.demo.persistence.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, timeout = 50000, isolation = Isolation.READ_UNCOMMITTED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(cacheNames = CacheConfig.user , key = "#userId", unless = "#result == null")
    public User getById(Integer userId) {
        return userRepository.getById(userId);
    }

    @Override
    @CacheEvict(cacheNames = CacheConfig.user, key = "#user.id")
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    @CachePut(cacheNames = CacheConfig.user, key = "#user.id")
    public User save(User user) {
        userRepository.save(user);
        return user;
    }

}
