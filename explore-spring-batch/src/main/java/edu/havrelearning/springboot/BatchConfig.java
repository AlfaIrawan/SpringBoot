package edu.havrelearning.springboot;


import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class BatchConfig {
	
	@Autowired
	private StepBuilderFactory sbf ;

	@Bean
	public Step Step() {
		
		return sbf.get("Step1")
				.<String, String>chunk(1)
				.reader(reader())
				.writer(writer())
				.processor(processor())
				.build();
		
	}
	
	@Bean
	public Reader reader() {
		
		return new Reader();
		
	}
	
	@Bean
	public Writer writer() {
		
		return new Writer();
		
	}
	
	@Bean
	public Processor processor() {
		
		return new Processor();
		
	}
	
	@Bean
	public MyJobListener myJobListener() {
		
		return new MyJobListener();
		
	}
	
}
