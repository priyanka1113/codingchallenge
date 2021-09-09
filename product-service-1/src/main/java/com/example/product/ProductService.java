package com.example.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	

		public String testController() {
		System.out.println("Hi");
		return "test";
	}

	public List<Product> getProducts() throws Exception {
		 return productRepo.findAll();
		//return productRepo.findproducts();
	}

	public Optional<Product> getProductbyId(int id) {
		return productRepo.findById(id);
	}

	public List<Product> getProductbyUPC(String UPC) {
		return productRepo.findByUPC(UPC);

	}

	public Product editProduct(Product product) {
		productRepo.save(product);
		return product;
	}
}
