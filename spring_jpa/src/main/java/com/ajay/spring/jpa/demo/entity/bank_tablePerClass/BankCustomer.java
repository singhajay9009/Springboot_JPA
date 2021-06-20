package com.ajay.spring.jpa.demo.entity.bank_tablePerClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* It is an abstract class defined as Entity to be extends by two other entities
   There would not be any table created for this class
   It only meant to be used as base class for child classes 'PrivilegedCustomer' & 'RegularCustomer'
   There would be respective tables created for both of the child classes.
   This parent class would not be getting any table.
   This is Table_PER_CLASS strategy
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BankCustomer {

    @Id
    private int id;

    @Column(name = "customer_type")
    private String customerType;
}
