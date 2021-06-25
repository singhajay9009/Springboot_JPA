package com.ajay.spring.jpa.demo;

import com.ajay.spring.jpa.demo.entity.relationship.oneToManyBiDirectional.Merchant;
import com.ajay.spring.jpa.demo.entity.relationship.oneToManyBiDirectional.Items;
import com.ajay.spring.jpa.demo.repository.MerchantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MerchantItemsTest {

    @Autowired
    MerchantRepository merchantRepository;

    @Test
    public void testCreateMerchantProducts(){

        Items items = new Items();
        items.setItemName("Cigar");

        Items items1 = new Items();
        items1.setItemName("Pipe");

        Merchant merchant = new Merchant();
        merchant.setName("Lucifer");
    //    merchant.setProducts(new HashSet<>(Arrays.asList(product, product1)));

        merchant.addItem(items);
        merchant.addItem(items1);

        merchantRepository.save(merchant);

    }

    @Test
    public void testRemoveMerchantItem(){
        Merchant merchant = merchantRepository.findById(2).get();
        merchantRepository.delete(merchant);

    }
}
