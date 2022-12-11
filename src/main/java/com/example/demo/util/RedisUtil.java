package com.example.demo.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisUtil {
    //private final RedisTemplate<String, Object> redisTemplate;
    private final RedisTemplate<String, Object> redisBlackListTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object o, int minutes) {
        //stringRedisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(o.getClass()));
        //stringRedisTemplate.opsForValue().set(key, (String) o, minutes, TimeUnit.MINUTES);
        stringRedisTemplate.opsForValue().set(key, String.valueOf(o), minutes, TimeUnit.MINUTES);
    }

    public Object get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    public boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    public void setBlackList(String key, Object o, Long milliSeconds, TimeUnit milliseconds) {
        redisBlackListTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(o.getClass()));
        redisBlackListTemplate.opsForValue().set(key, String.valueOf(o), milliSeconds, TimeUnit.MILLISECONDS);
        //stringRedisTemplate.opsForValue().set();
    }


    public Object getBlackList(String key) {
        return redisBlackListTemplate.opsForValue().get(key);
    }

    public boolean deleteBlackList(String key) {
        return redisBlackListTemplate.delete(key);
    }

    public boolean hasKeyBlackList(String key) {
        return redisBlackListTemplate.hasKey(key);
    }
    //내가뵜을 땐 여기가 문제임

    public void setDataExpire(String key, Object value, long duration){
        Duration expireDuration = Duration.ofSeconds(duration);
        stringRedisTemplate.opsForValue().set(key, String.valueOf(value), expireDuration);
    }

//    public boolean isBlacklist(String accessToken) {
//        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
//        String value = valueOperations.get(BLACKLIST + accessToken);
//
//        return value != null && !value.isEmpty();
//    }
}
