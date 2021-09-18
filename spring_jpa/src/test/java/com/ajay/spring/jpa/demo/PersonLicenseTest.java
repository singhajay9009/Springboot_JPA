package com.ajay.spring.jpa.demo;


import com.ajay.spring.jpa.demo.entity.relationship.oneToOne.License;
import com.ajay.spring.jpa.demo.entity.relationship.oneToOne.License2;
import com.ajay.spring.jpa.demo.entity.relationship.oneToOne.Person;
import com.ajay.spring.jpa.demo.entity.relationship.oneToOne.Person2;
import com.ajay.spring.jpa.demo.repository.LicenseRepository;
import com.ajay.spring.jpa.demo.repository.PersonRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class PersonLicenseTest {

    @Autowired
    LicenseRepository licenseRepository;

    @Autowired
    PersonRepository personRepository;

    // Need to validate hibernate cache
    @Autowired
    EntityManager entityManager;

    @Test
    public void testCreatePersonLicense(){

        License license = new License();
        license.setType("car");

        String inputString = "04-10-2005";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fromDate = LocalDate.parse(inputString,formatter);
        license.setFromDate(fromDate);

        String inString = "04-10-2030";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate toDate = LocalDate.parse(inString,formatter1);
        license.setToDate(toDate);

        Person person = new Person();
        person.setName("Chris");

        license.setPerson(person);

        licenseRepository.save(license);

    }

    @Test
    @Transactional
    public void testFetchPersonLicense(){
       License license = licenseRepository.findById(2).get();
        System.out.println(license.getPerson().getName());
    }

    @Test
    public void testRemovePersonLicense(){
        License license = licenseRepository.findById(1).get();
        licenseRepository.delete(license);

    }

    /// Managing by Person2

    @Test
    public void testCreatePersonAndLicense(){

        // this will manage the relationship using personrepo instead licenserepo
        Person2 person2 = new Person2();
        person2.setName("Tracie");

        License2 license2 = new License2();

        String inputString = "04-10-2005";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fromDate = LocalDate.parse(inputString,formatter);
        license2.setFromDate(fromDate);

        String inString = "04-10-2030";
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate toDate = LocalDate.parse(inString,formatter1);
        license2.setToDate(toDate);

        license2.setType("Aeroplane");

        person2.setLicense(license2);
        license2.setPerson(person2);

        personRepository.save(person2);
    }

    @Test
    public void testFetchPersonAndLicense(){

        Person2 person2 = personRepository.findById(2).get();

        System.out.println(person2.getLicense().getType());
    }

    @Test
    public void testDeletePersonAndLicense(){

        Person2 person2 = personRepository.findById(2).get();

        //will delete license2 first and then delete person2
        personRepository.delete(person2);
    }

    @Test
    @Transactional
    public void testHibernateFirstCache(){

        // hibernate will execute select only once
        //@Transactional is imp to enable cache
        personRepository.findById(1);
        personRepository.findById(1);

    }

    @Test
    @Transactional
    public void testHibernateFirstCacheEvict(){

        Session session = entityManager.unwrap(Session.class);
        Person2 person2 = personRepository.findById(1).get();

        personRepository.findById(1);

        session.evict(person2);

        personRepository.findById(1);

    }
}
