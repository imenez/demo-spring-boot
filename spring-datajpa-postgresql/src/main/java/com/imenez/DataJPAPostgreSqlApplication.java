package com.imenez;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DataJPAPostgreSqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataJPAPostgreSqlApplication.class, args);
    }
}
