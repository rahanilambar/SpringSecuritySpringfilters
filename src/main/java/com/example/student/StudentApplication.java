package com.example.student;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class StudentApplication {
	public static void main(String[] args) {
//		SpringApplication.run(StudentApplication.class, args);
            new SpringApplicationBuilder(StudentApplication.class)
                    .properties("spring.config.name:jdbc")
                    .build()
                    .run(args);
        }
}
