package edu.havrelearning.springboot.entities.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.havrelearning.springboot.entities.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}
