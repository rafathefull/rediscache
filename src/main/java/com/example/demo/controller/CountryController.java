package com.example.demo.controller;

import com.example.demo.persistence.domain.Country;
import com.example.demo.persistence.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/{code}")
    public ResponseEntity<Country> getCode(@PathVariable("code") String code) {
        Country  country = countryService.getCode(code);

        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @Operation(summary = "Listar todos los países")
    @GetMapping("")
    public ResponseEntity<List<Country>> listAll() {
        List<Country> countries = countryService.listAll();

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

}