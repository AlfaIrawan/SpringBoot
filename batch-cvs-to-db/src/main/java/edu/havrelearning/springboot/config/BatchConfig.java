package edu.havrelearning.springboot.config;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import edu.havrelearning.springboot.model.Product;



@Configuration
public class BatchConfig {

	@Bean
	public ItemReader<Product> reader() {
		
		FlatFileItemReader<Product> reader = new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("product.csv"));
		
		DefaultLineMapper<Product> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
		lineTokenizer.setNames("id", "name", "description", "price");
		
		BeanWrapperFieldSetMapper<Product> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		
		fieldSetMapper.setTargetType(Product.class);
		
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		
		return reader;
		
	}
	
	public ItemProcessor<Product, Product> processor() {
		
		
		return (p)->{ 
			p.setPrice(p.getPrice()-p.getPrice()*10/100); 
			return p;
		};
		
	}
	
}
