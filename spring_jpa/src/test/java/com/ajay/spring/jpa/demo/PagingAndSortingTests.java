package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

@SpringBootTest
public class PagingAndSortingTests {

    @Autowired
    PagingAndSortingRepository pagingAndSortingRepository;

    @Test
    public void testFindAll(){

        Pageable pageable = PageRequest.of(0,2);
        Page<Product> lstProduct = pagingAndSortingRepository.findAll(pageable);
        lstProduct.forEach(p -> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllSorting(){
        Iterable<Product> itr = pagingAndSortingRepository.findAll(Sort.by("name"));
        itr.forEach(p-> System.out.println(p.getName()));
    }

    @Test
    public void testFindAllSortingMultiple(){
        Iterable<Product> itr = pagingAndSortingRepository.findAll(Sort.by("name", "price"));
        itr.forEach(p-> System.out.println(p.getName() + " ==== " + p.getPrice()));
    }

    @Test
    public void testFindAllSortingMultipleWithDirection(){
        Iterable<Product> itr = pagingAndSortingRepository.findAll(Sort.by(Sort.Direction.ASC, "name", "price"));
        itr.forEach(p-> System.out.println(p.getName() + " ==== " + p.getPrice()));
    }

    @Test  // Sorting in different directions for different fields using sorting orders
    public void testFindAllSortingMultipleSortOrderWithDirection(){
        Iterable<Product> itr = pagingAndSortingRepository.findAll(
                Sort.by(new Sort.Order(Sort.Direction.ASC, "name"), new Sort.Order(Sort.Direction.DESC, "price")));
        itr.forEach(p-> System.out.println(p.getName() + " ==== " + p.getPrice()));
    }

    @Test  // Sorting in different directions for different fields using sorting orders
    public void testFindAllPagingAndSorting(){
        Pageable pageable = PageRequest.of(1,2, Sort.Direction.ASC, "name");
        Page<Product> pageProducts = pagingAndSortingRepository.findAll(pageable);

        pageProducts.forEach(p-> System.out.println(p.getName() + " ==== " + p.getPrice()));
    }
}
