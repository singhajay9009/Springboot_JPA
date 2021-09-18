package com.ajay.jpa.hibernate.demo.entity.oneToMany;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Asset {

    @Id
    @Column(name = "asset_id")
    private int assetId;

    @Column(name = "asset_name")
    private String assetName;
}
