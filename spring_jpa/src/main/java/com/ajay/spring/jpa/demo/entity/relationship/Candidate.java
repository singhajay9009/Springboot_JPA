package com.ajay.spring.jpa.demo.entity.relationship;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter @Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch=FetchType.LAZY)  // mappedBy determine who is owning entity, here it is candidate. CascadeType.ALL will determine that any operation ( insert, update , delete) should be cascaded to child entity.
    // So in this case, when we persist Candidate record, PhoneNumber would also be persisted in the phonenumer table.
    //If we don't use cascadeType here, then only candidate would be saved, no record will be saved in phone number table.

    //MappedBy tells hibernate that the key for the relationship is on the other side.
    //MappedBy means that hibernate is telling Candidate entity that it is responsible to maintain 'candidate' in the other table.
    private Set<PhoneNumber> phoneNumbers;

    public void addPhoneNUmber(PhoneNumber ph){
        if(ph != null) {
            if(phoneNumbers == null){
                phoneNumbers = new HashSet<>();
            }
            ph.setCandidate(this);
            phoneNumbers.add(ph);
        }
    }

}
