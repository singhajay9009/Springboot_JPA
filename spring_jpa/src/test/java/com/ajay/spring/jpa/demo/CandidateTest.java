package com.ajay.spring.jpa.demo;


import com.ajay.spring.jpa.demo.entity.relationship.Candidate;
import com.ajay.spring.jpa.demo.entity.relationship.PhoneNumber;
import com.ajay.spring.jpa.demo.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class CandidateTest {

    @Autowired
    CandidateRepository candidateRepository;

    @Test
    public void testCreateCandidate(){
//
//        Candidate candidate = Candidate.builder()
//                .name("Cavin")
//               // .phoneNumbers(phoneNumberSet)
//                .build();

   //     Candidate candidate = new Candidate();
   //     candidate.setName("Eli");

        PhoneNumber phoneNumber_1 = PhoneNumber.builder()
                .phNumber(423432424)
                .type("home")
                .build();

        PhoneNumber phoneNumber_2 = PhoneNumber.builder()
                .phNumber(7890897)
                .type("home")
                .build();

   //     Set<PhoneNumber> phoneNumberSet = new HashSet<>(Arrays.asList(phoneNumber_1, phoneNumber_2));



        Candidate candidate = new Candidate();
        candidate.setName("Irwin");
        candidate.addPhoneNUmber(phoneNumber_1);
        candidate.addPhoneNUmber(phoneNumber_2);

        candidateRepository.save(candidate);
    }

    @Test
    @Transactional
//    @Rollback(value = false)
    public void testLoadCandidate(){
        Candidate candidate = candidateRepository.findById(2).get();

        candidate.getPhoneNumbers().forEach(p -> p.setType("home"));
        candidateRepository.save(candidate);

    }

    @Test
    public void testDeleteCandidate(){
        Candidate candidate = candidateRepository.findById(2).get();

        candidateRepository.delete(candidate);
    }

}
