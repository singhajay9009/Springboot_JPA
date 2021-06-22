package com.ajay.spring.jpa.demo.entity.bank_joinedTable;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "employee_shop")
@PrimaryKeyJoinColumn(name = "id") // this is column name from child table
public class EmployeeShop extends Shop {

    @Id
    private int id;

    private String name;

    private int age;
}
