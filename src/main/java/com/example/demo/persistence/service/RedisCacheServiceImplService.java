package com.example.demo.persistence.service;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RedisCacheServiceImplService implements RedisCacheService {

    private RedisClient redisClient;

    public void clearCache() {
        // Obtener comandos sincrónicos
        RedisCommands<String, String> syncCommands = redisClient.connect().sync();

        // Limpiar la caché
        syncCommands.flushall();

        // Cerrar la conexión (podrías optar por no cerrar aquí si la conexión es usada frecuentemente)
        redisClient.shutdown();

    }
}
