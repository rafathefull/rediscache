package com.example.demo.persistence.service;

import com.example.demo.config.CacheConfig;
import com.example.demo.persistence.domain.Country;
import com.example.demo.persistence.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, timeout = 50000, isolation = Isolation.READ_UNCOMMITTED)
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override

    @Cacheable(cacheNames = CacheConfig.country, key = "#code", unless = "#result == null")
    public Country getCode(String code) {
        return countryRepository.getCode(code);
    }

    @Override
    @Cacheable(cacheNames = CacheConfig.countryList)
    public List<Country> listAll() {
        return countryRepository.listAll();
    }

}
