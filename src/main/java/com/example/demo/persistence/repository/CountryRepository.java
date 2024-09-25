package com.example.demo.persistence.repository;

import com.example.demo.persistence.domain.Country;

import java.util.List;

public interface CountryRepository {


    Country getCode(String code);
    List<Country> listAll();
}