package com.ajay.jpa.hibernate.demo;

import com.ajay.jpa.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import javax.persistence.Query;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(HibernateDemoApplication.class, args);

		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.ajay.jpa.hibernate.demo.entity.Employee.class);

		StandardServiceRegistryBuilder builder =
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();



		String inputString = "11-11-2012";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate inputDate = LocalDate.parse(inputString,formatter);
	//	System.out.println(formatter.format(inputString));

		Employee employee1 = Employee.builder()
				.firstName("Robin")
				.lastName("Matthews")
				.joiningDate(inputDate)
				.build();
		Employee employee2 = Employee.builder()
				.firstName("John")
				.lastName("White")
				.joiningDate(inputDate)
				.build();
		Employee employee3 = Employee.builder()
				.firstName("Ami")
				.lastName("Rose")
				.joiningDate(inputDate)
				.build();

		session.save(employee1);
		session.save(employee2);
		session.save(employee3);

		Query query = session.createQuery("from Employee");
		List<Employee> employeeList = query.list();

		Query query1 = session.createQuery("from Employee where joiningDate >= :date order by firstName");

		query1.setParameter("date", LocalDate.parse("11-11-2012",formatter));
		List<Employee> employeeList2 = query1.list();

		for(Employee e: employeeList2){
			System.out.println("Employee is: " + e);
		}
		transaction.commit();
//
//		Transaction transaction1 = session.beginTransaction();
//		Employee emp = session.get(Employee.class, 101);
//		System.out.println("Employee is: " + emp.getFirstName());
//
//		emp.setFirstName("John");
//		session.save(emp);
//		transaction1.commit();

//		System.out.println("Employee after changing the name is: " + session.get(Employee.class, 101).getFirstName());
		session.close();
		sessionFactory.close();


	}

}
