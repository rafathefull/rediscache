package com.example.demo.persistence.service;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheServiceImplService implements RedisCacheService {

    @Value("${spring.data.redis.host}")
    private String host;

    @Value("${spring.data.redis.port}")
    private String port;

    public void clearCache() {
        try (RedisClient redisClient = RedisClient.create("redis://" + host + ":" + port)) {
            // Obtener comandos sincrónicos
            RedisCommands<String, String> syncCommands = redisClient.connect().sync();
            // Limpiar la caché
            syncCommands.flushall();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
