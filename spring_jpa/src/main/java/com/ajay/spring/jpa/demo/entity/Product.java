package com.ajay.spring.jpa.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Builder
@Data  // @ToString, @EqualsAndHashCode, @Getter  @Setter and @RequiredArgsConstructor
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private int id;

    private String name;

    @Column(name= "description")
    private String desc;

    private Double price;


}
