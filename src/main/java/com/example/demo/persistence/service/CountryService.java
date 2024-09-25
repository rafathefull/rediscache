package com.example.demo.persistence.service;

import com.example.demo.persistence.domain.Country;

import java.util.List;

public interface CountryService {

    Country getCode(String code);
    List<Country> listAll();

}
