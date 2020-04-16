package edu.havrelearning.springboot;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class BatchCvsToDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchCvsToDbApplication.class, args);
	}

}
