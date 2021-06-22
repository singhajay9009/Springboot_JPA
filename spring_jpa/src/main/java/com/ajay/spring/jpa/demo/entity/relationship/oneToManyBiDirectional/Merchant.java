package com.ajay.spring.jpa.demo.entity.relationship.oneToManyBiDirectional;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Setter
@Getter
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    private Set<Items> items;

    public void addProduct(Items item){
        Optional.ofNullable(item).ifPresent(itm -> {
            this.items = Optional.ofNullable(this.items).orElseGet(HashSet::new);
            this.items.add(itm);
            itm.setMerchant(this);
        });
    }
}
