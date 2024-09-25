package com.example.demo.controller;

import com.example.demo.persistence.service.RedisCacheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/redis")
public class RedisController {

    private final RedisCacheService redisCacheService;

    /**
     * Clear the cache using the RedisCacheService
     *
     * @return ResponseEntity<String>
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