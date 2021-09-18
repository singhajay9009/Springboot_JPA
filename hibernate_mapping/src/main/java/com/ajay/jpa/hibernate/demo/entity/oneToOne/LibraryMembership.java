package com.ajay.jpa.hibernate.demo.entity.oneToOne;

import com.ajay.jpa.hibernate.demo.entity.oneToOne.Student;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "library_membership")
public class LibraryMembership {

    @Id
    @Column(name = "lib_mem_id")
    private int libMemId;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @OneToOne(mappedBy = "libraryMembership")
    private Student student;
}
