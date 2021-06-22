package com.ajay.spring.jpa.demo.entity.bank_joinedTable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/* In the 'JOINED' table strategy, fields which are specific to subclass
are mapped to child table and a join is performed to instantiate the subclass
 */

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public abstract class Shop {

    @Id
    private int id;

    private String type;
}
