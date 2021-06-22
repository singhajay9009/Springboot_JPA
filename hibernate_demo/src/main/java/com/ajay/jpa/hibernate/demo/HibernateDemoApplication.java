package com.ajay.jpa.hibernate.demo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.ajay.jpa.hibernate.demo.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

		configuration.addAnnotatedClass(com.ajay.jpa.hibernate.demo.entity.Employee.class);

		StandardServiceRegistryBuilder builder =
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		try{
			String inputString = "11-11-2012";
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate inputDate = LocalDate.parse(inputString,formatter);
			//	System.out.println(formatter.format(inputString));

			Employee employee1 = Employee.builder()
					.firstName("Erick")
					.lastName("hopes")
					.joiningDate(inputDate)
					.hobbies("football")
					.build();
			Employee employee2 = Employee.builder()
					.firstName("ron")
					.lastName("Vandi")
					.joiningDate(LocalDate.parse("23-08-2009",formatter))
					.hobbies("basketball")
					.build();
			Employee employee3 = Employee.builder()
					.firstName("Amber")
					.lastName("Novaska")
					.joiningDate(LocalDate.parse("13-03-2016",formatter))
					.hobbies("sailing")
					.build();

//			session.save(employee1);
//			session.save(employee2);
//			session.save(employee3);

		Query query = session.createQuery("from Employee");
		List<Employee> employeeList = query.getResultList();

		// HQL ---- Hibernate Query Language
		Query query1 = session.createQuery("from Employee where joiningDate >= :date order by firstName");

		query1.setParameter("date", LocalDate.parse("11-11-2013",formatter));

		List<Object> employeeList2 = query1.list();

		for(Object e: employeeList2){
			System.out.println("Employee is: " + e);
		}

		// Query2 operations // createSQLQuery method is used to create native SQL queries
			Query query2 = session.createSQLQuery(
				"Select * from employee where emp_id < :empId")
				.setParameter("empId", 3)
				.addEntity(Employee.class);

		List<Employee> result = query2.getResultList();

		for(Employee e: result){
			System.out.println("Employee from list2 is: " + e);
		}

		Query query3 = session.createQuery("Select firstName from Employee where emp_id = 1");
	//	query3.setParameter("empId", 1);
	//	List<Object> reslt = query3.list();

		String name = (String)query3.uniqueResult();

		System.out.println("First name for employee with id = 1 is: " + name);

		// Fetching only respective columns

		Query query4 = session.createSQLQuery("Select first_name, last_name from employee where emp_id >2");
		query4.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);

		List employees = query4.list();

		for(Object o: employees){
			Map m = (Map)o;
			System.out.println("First name is: " + m.get("first_name") + ". Last name is: " + m.get("last_name"));
		}

		// using get method to retrieve a specific Object
		Employee emp = session.get(Employee.class, 2); // It fires the query in db. It retirves the rela object

		Employee emp2 = session.load(Employee.class, 3); // It does not fire the query in db. It gives a proxy object.
			// It fires the query only when obj is used e.g. printing it using Syso.

		// Also get returns null if no obj found, whereas load throws noObjectFound exception.

		System.out.println("Employee is: " + emp);

		transaction.commit();

		// Comment all above lines starting from try block to observe 2nd level caching easily
		Employee empFromSessionOne = session.get(Employee.class, 4);
		System.out.println("Employee from session one with emp_id:4 is: " + empFromSessionOne);
		session.close();

		Session session2 = sessionFactory.openSession();
		Employee empFromSessionTwo = session2.get(Employee.class, 4);
		System.out.println("Employee from session two with emp_id:4 is: " + empFromSessionTwo);
		session2.close();
		}

		finally{

			//session.close();
			//sessionFactory.close();
		}
	}

}
