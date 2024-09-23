package com.example.demo.controller;

import com.example.demo.persistence.domain.User;
import com.example.demo.persistence.domain.dto.UserDTO;
import com.example.demo.persistence.service.RedisCacheService;
import com.example.demo.persistence.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/demo")
public class DemoController {

    private final ModelMapper modelMapper;

    private final UserService userService;

    private final RedisCacheService redisCacheService;

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

    /**
     * Clear the cache using the RedisCacheService
     *
     * @return
     */
    @Operation(summary = "Limpiar la caché de Redis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cache limpiada correctamente"),
            @ApiResponse(responseCode = "500", description = "Error al limpiar la caché")
    })
    @DeleteMapping("/clearCache")
    public ResponseEntity<String> clearCache() {
        redisCacheService.clearCache();

        return new ResponseEntity<>("Cache cleared", HttpStatus.OK);
    }

}