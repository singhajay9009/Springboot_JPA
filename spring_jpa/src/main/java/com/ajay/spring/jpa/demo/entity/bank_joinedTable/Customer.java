package com.ajay.spring.jpa.demo.entity.bank_joinedTable;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "customer_shop")
@PrimaryKeyJoinColumn(name = "id") // This is the child table column name here
public class Customer extends Shop{

    @Id
    private int id;

    private String name;

    private int age;
}
