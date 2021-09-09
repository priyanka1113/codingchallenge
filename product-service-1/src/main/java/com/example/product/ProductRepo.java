package com.example.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	
	List<Product> findByUPC(String UPC);
	
	
	  @Query("from Product order by id") 
	  List<Product> findproducts();
	 }
