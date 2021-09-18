package com.ajay.jpa.hibernate.demo;

import com.ajay.jpa.hibernate.demo.entity.Club;
import com.ajay.jpa.hibernate.demo.entity.LibraryMembership;
import com.ajay.jpa.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(Club.class);
		configuration.addAnnotatedClass(LibraryMembership.class);
	//	configuration.addPackage("com.ajay.jpa.hibernate.demo.entity");

		StandardServiceRegistryBuilder builder =
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		String inputString = "11-11-2012";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate inputDate = LocalDate.parse(inputString,formatter);


		Student student = new Student();
		student.setFirstName("Adwin");
		student.setLastName("White");
		student.setHobbies("Singing");
		student.setStudentId(1);
		student.setJoiningDate(inputDate);

		LibraryMembership libraryMembership = new LibraryMembership();
		libraryMembership.setLibMemId(101);
		libraryMembership.setIssueDate(LocalDate.parse("11-12-2014",formatter));
		libraryMembership.setExpiryDate(LocalDate.parse("11-12-2016",formatter));

		student.setLibraryMembership(libraryMembership);

		session.save(student);
		session.save(libraryMembership);

		transaction.commit();

		session.close();

		sessionFactory.close();

	}

}
