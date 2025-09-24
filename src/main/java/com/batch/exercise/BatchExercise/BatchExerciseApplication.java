package com.batch.exercise.BatchExercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.batch.exercise.BatchExercise")
@EnableJpaRepositories(basePackages = "com.batch.exercise.BatchExercise.model.repository")
public class BatchExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchExerciseApplication.class, args);
	}

}
