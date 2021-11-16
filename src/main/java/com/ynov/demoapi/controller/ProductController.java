package com.ynov.demoapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ynov.demoapi.model.Product;

@RestController
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@GetMapping("/product/{name}")
	public Product getproductByName(@PathVariable String name ) {
		
    //Simulate the code which loads an existing product by this name	
	Product p = new Product();
	p.setName(name);
	p.setDescription("Description of the product");
	p.setCost(10);
	// End simulation
	
	return p;
	}
	
	@GetMapping("/product")
	public List<Product> getProducts(){
		//Simulate
		Product p1 = new Product();
		p1.setName("Demon Slayer");
		p1.setDescription("");
		p1.setCost(720);
		
		Product p2 = new Product();
		p2.setName("You");
		p2.setDescription("");
		p2.setCost(1500);
		
		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		
		return list;	
		
	}

	
	@PostMapping("/product")
	public void addProduct(@RequestBody Product product) {
		logger.info(product.getName() + "" + product.getDescription() + "" + product.getCost());
	}
}
