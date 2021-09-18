package com.ajay.jpa.hibernate.demo.entity.oneToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Asset {

    @Id
    @Column(name = "asset_id")
    private int assetId;

    @Column(name = "asset_name")
    private String assetName;

    @ManyToOne
    private Employee employee;
}
