package com.imenez.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ElasticsearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}
