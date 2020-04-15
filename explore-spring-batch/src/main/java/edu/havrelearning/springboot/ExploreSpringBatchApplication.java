package edu.havrelearning.springboot;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@EnableBatchProcessing
public class ExploreSpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExploreSpringBatchApplication.class, args);
	}

}
