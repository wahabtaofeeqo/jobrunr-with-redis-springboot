package com.example.jobrunr.redis.springboot;

import io.lettuce.core.RedisClient;
import org.jobrunr.jobs.mappers.JobMapper;
import org.jobrunr.storage.StorageProvider;
import org.jobrunr.storage.nosql.redis.LettuceRedisStorageProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobrunrRedisSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobrunrRedisSpringbootApplication.class, args);
    }
    
    @Bean
    StorageProvider initProvider(JobMapper mapper) {
        RedisClient client = RedisClient.create("redis://localhost:6379/0");
        LettuceRedisStorageProvider provider = new LettuceRedisStorageProvider(client);
        provider.setJobMapper(mapper);
        return provider;
    }
}
