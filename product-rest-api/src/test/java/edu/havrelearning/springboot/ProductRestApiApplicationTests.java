package edu.havrelearning.springboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.sun.org.apache.bcel.internal.generic.NEW;

import edu.havrelearning.springboot.entities.Product;

@SpringBootTest
class ProductRestApiApplicationTests {
	
	@Value("${product-rest-api.service.url}")
	private String BASE_URL;

	@Test
	void testGetProduct() {
		System.out.println(BASE_URL);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject( BASE_URL + "product/1", Product.class);
		
		assertNotNull(product);
		assertEquals("Alfa Pungki", product.getName());
		
	}
	
	@Test
	void testCreateProduct() {
		
		Product product = new Product();
		product.setId(7);
		product.setName("Alfa Pungki");
		product.setDescription("");
		product.setPrice(70);
		
		RestTemplate restTemplate = new RestTemplate();
		Product productResponse = restTemplate.postForObject(BASE_URL + "product", product, Product.class);
		
		assertNotNull(productResponse);
		assertNotNull(productResponse.getId());
		assertEquals("Alfa Pungki", productResponse.getName());
		
	}
	
	@Test
	void testUpdateProduct() {
		
		Product product = new Product();
		product.setId(3);
		product.setName("Alfa");
		product.setDescription("Testing");
		product.setPrice(60);
		
		RestTemplate restTemplate = new RestTemplate();
		Product productResponse = restTemplate.postForObject(BASE_URL + "product", product, Product.class);
		
		assertNotNull(productResponse);
		assertNotNull(productResponse.getId());
		assertEquals("Alfa", productResponse.getName());
		
		/* CAN ALSO LIKE THIS */
		/*
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject( BASE_URL + "product/1", Product.class);
		product.setPrice(60);
		restTemplate.put(BASE_URL + "product", product);
		 */
		
	}
	
	@Test
	void testDeleteProduct() {
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(BASE_URL + "product/4");
		
	}

}
