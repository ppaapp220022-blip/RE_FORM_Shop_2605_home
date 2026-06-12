package com.re_form_shop_2605.config;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import static org.junit.jupiter.api.Assertions.*;
@Log4j2
@SpringBootTest
class RedisConfigTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    void getRedisTemplate() {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();

        String key = "name";
        valueOperations.set(key,"test");
        String value = valueOperations.get(key);
    }

}