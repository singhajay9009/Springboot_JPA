package com.ajay.jpa.hibernate.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Club {

    @Id
    @Column(name = "club_id")
    private int clubId;

    @Column(name = "club_name")
    private String clubName;
}
