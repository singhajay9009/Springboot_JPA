package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.Product;
import com.ajay.spring.jpa.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Product product = Product.builder()
				.id(1)
				.name("macbook")
				.desc("laptop")
				.price(1100d)
				.build();

		// when we call save , hibernate first check if record with this id exists
		// if no, it further inserts the record
		// if yes, it checks further the attribute values
		// if there is no change, it ignore running update
		// else it will run update query. Thats how hibernate internally handles insert /update
		productRepository.save(product);

	}

	public void testFind(){
		Optional<Product> optProduct = productRepository.findById(1);
		Product product = optProduct.get();

		Assertions.assertNotNull(product);

		Assertions.assertEquals("macbook", product.getName());

	}

	@Test
	public void testUpdate(){
		Optional<Product> optProduct = productRepository.findById(1);
		Product product = optProduct.get();

		product.setPrice(1100d);

		Assertions.assertNotNull(productRepository.save(product));

	}

}
