package com.example.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("home")
	
	public String testController() {
		System.out.println("Hi");
		return "test";
	}
	
	@RequestMapping("hello")
	public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}

	@GetMapping("/productlist")
	@ResponseBody
	public List<Product> getProducts() throws Exception {
		// return repo.findAll();
		return productService.getProducts();

	}

	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductbyId(@PathVariable("id") int id) {
		Product product = productService.getProductbyId(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not found with id = " + id));
		return new ResponseEntity<> (product,HttpStatus.OK);
	}

	@GetMapping("/barcode/{UPC}")
	public ResponseEntity<List<Product>> getProductbyUPC(@PathVariable("UPC") String UPC) throws Exception {
		List<Product> product =  productService.getProductbyUPC(UPC);
				return new ResponseEntity<> (product,HttpStatus.OK);

	}

	@PutMapping("/editproduct")
	public Product editProduct(@RequestBody Product product) {
		productService.editProduct(product);
		return product;
	}

}
