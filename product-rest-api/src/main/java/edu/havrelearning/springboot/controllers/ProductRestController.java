package edu.havrelearning.springboot.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.havrelearning.springboot.entities.Product;
import edu.havrelearning.springboot.entities.repositories.ProductRepository;



@RestController
public class ProductRestController {
	
	@Autowired
	ProductRepository productRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getProducts() {
		
		return productRepository.findAll();
		
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	@Cacheable("product-cache")
	public Product getProduct(@PathVariable("id")int id) {
		
		LOGGER.info("finding product by ID: " + id);
		return productRepository.findById(id).get();
		
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product model) {
		
		return productRepository.save(model);
		
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product model) {
		
		return productRepository.save(model);
		
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	@CacheEvict("product-cache")
	public void deleteProduct(@PathVariable("id")int id) {
	
		productRepository.deleteById(id);
		
	}
	
	
}
