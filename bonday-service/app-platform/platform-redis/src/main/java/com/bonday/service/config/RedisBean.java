package com.bonday.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by yunge on 16/4/5.
 */
@Component
public class RedisBean {

    private StringRedisTemplate template;

    @Autowired
    public RedisBean(StringRedisTemplate template) {
        this.template = template;
    }
}
