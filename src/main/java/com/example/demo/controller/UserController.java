package com.example.demo.controller;

import com.example.demo.persistence.domain.User;
import com.example.demo.persistence.domain.dto.UserDTO;
import com.example.demo.persistence.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final ModelMapper modelMapper;

    private final UserService userService;


    @GetMapping
    public ResponseEntity<String> sayHello() {

        return ResponseEntity.ok("hello Redis!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Integer id) {
        User user = userService.getById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> delete(@PathVariable("id") Integer id) {
        User user = userService.getById(id);
        userService.delete(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setName(userDTO.getUserName());
        user.setActive(true);
        user.setBlocked(false);
        user.setCreatedDate(LocalDateTime.now());
        user.setErrorLoginAttempts(0);
        user = userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}