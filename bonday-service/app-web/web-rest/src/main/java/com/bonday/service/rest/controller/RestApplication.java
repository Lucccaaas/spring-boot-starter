package com.bonday.service.rest.controller;

import org.apache.solr.client.solrj.SolrServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;

/**
 * Created by yunge on 16/4/3.
 */
@SpringBootApplication(scanBasePackages = "com.bonday")
@EnableMongoAuditing
public class RestApplication {
    @Resource
    SolrServer solrServer;

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
