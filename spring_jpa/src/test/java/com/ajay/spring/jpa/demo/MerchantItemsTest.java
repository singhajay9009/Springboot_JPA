package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.relationship.oneToManyBiDirectional.Merchant;
import com.ajay.spring.jpa.demo.entity.relationship.oneToManyBiDirectional.Items;
import com.ajay.spring.jpa.demo.repository.MerchantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.stream.Collectors;

@SpringBootTest
public class MerchantItemsTest {

    @Autowired
    MerchantRepository merchantRepository;

    @Test
    public void testCreateMerchantProducts(){

        Items items = new Items();
<<<<<<< HEAD
        items.setItemName("Cigar");

        Items items1 = new Items();
        items1.setItemName("Pipe");

        Merchant merchant = new Merchant();
        merchant.setName("Lucifer");
    //    merchant.setProducts(new HashSet<>(Arrays.asList(product, product1)));

        merchant.addProduct(items);
        merchant.addProduct(items1);
=======
        items.setItemName("Wine");

        Items items1 = new Items();
        items1.setItemName("Whisky");

        Merchant merchant = new Merchant();
        merchant.setName("Bella");
    //    merchant.setProducts(new HashSet<>(Arrays.asList(product, product1)));

        merchant.addItem(items);
        merchant.addItem(items1);
>>>>>>> 50b9da701474ae84a87bff71836bd596a174e56c

        merchantRepository.save(merchant);

    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void testRemoveMerchantItem(){
        Merchant merchant = merchantRepository.findById(3).get();
       // merchantRepository.re(merchant);
        // will remove the very first item among the found ones
        merchant.removeItem(merchant.getItems().stream().findFirst().get());

    }
}
