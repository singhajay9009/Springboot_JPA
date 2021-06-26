package com.ajay.spring.jpa.demo.entity.relationship.oneToManyBiDirectional;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "merchant_id", referencedColumnName = "id")
    private Merchant merchant;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PostComment )) return false;
//        return id != null && id.equals(((PostComment) o).getId());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Items )) return false;
        return itemId != 0 && itemId == ((Items) o).getItemId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    
}
