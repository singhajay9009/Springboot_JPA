package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.Employee;
import com.ajay.spring.jpa.demo.entity.Product;
import com.ajay.spring.jpa.demo.repository.EmployeeRepository;
import com.ajay.spring.jpa.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	EmployeeRepository employeeRepository;

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

	@Test
	public void testCount() {
		long countRecords = productRepository.count();
		System.out.println("Count of Records >>>>>>>> : " + countRecords);
	}

	@Test
	public void testExist(){
		if (productRepository.existsById(1)) {
			productRepository.delete(productRepository.findById(1).get());
		}
	}

	@Test
	public void testEmployeeIdGeneration(){
		Employee employee = Employee.builder()
				.name("John White")
				.build();

		employeeRepository.save(employee);

	}

	@Test
	public void testFindProductByPrice(){
		Optional<List<Product>> optListProducts = productRepository.findByPrice(100.000);

		List<Product> lstProducts = optListProducts.orElseThrow(NullPointerException::new);

		for (Product lstProduct : lstProducts) {
			Double price = lstProduct.getPrice();
			Assertions.assertEquals(100.000, price, ()-> "Price not 100.000");

	//		Assertions.assertEquals(100.000, lstProduct.getPrice());

		}

	}

	@Test
	public void testFindProductByName(){
		List<Product> lstProds = productRepository.findByName("dell");

		List<Product> lstProducts = Optional.ofNullable(lstProds).orElseThrow(NullPointerException::new);

		lstProducts.forEach(p -> Assertions.assertEquals("dell", p.getName()));

	}

	@Test
	public void testFindByMultipleFields(){
		Optional<List<Product>> lstProds = productRepository.findByNameAndPrice("dell", 100.000);

		List<Product> lstProducts = lstProds.orElseThrow(NullPointerException::new);

		Assertions.assertEquals(1, lstProducts.size());

	}

	@Test
	public void testFindByPriceGreaterThan(){
		List<Product> lstProds = productRepository.findByPriceGreaterThan(300.000);

		List<Product> lstProducts = Optional.ofNullable(lstProds).orElseThrow(NullPointerException::new);

		lstProducts.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindByDescContains(){
		List<Product> lstProds = productRepository.findByDescContains("disk");

		List<Product> lstProducts = Optional.ofNullable(lstProds).orElseThrow(NullPointerException::new);

		lstProducts.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindByPriceBetween(){
		List<Product> lstProds = productRepository.findByPriceBetween(300.000, 900.000);

		List<Product> lstProducts = Optional.ofNullable(lstProds).orElseThrow(NullPointerException::new);

		lstProducts.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindByDescLike(){
		List<Product> lstProds = productRepository.findByDescLike("%ph%");  // finding headphone, id = 5

		List<Product> lstProducts = Optional.ofNullable(lstProds).orElseThrow(NullPointerException::new);

		lstProducts.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindByIdsIn(){
		List<Product> lstProds = productRepository.findByIdIn(Arrays.asList(2,3,4));  // finding headphone, id = 5

		List<Product> lstProducts = Optional.ofNullable(lstProds).orElseThrow(NullPointerException::new);

		lstProducts.forEach(p -> System.out.println(p.getName()));

	}


}
