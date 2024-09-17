package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private ModelMapper modelMapper;

    @Bean
    public ModelMapper modelMapper() {
        this.modelMapper = new ModelMapper();

        return modelMapper;
    }


}