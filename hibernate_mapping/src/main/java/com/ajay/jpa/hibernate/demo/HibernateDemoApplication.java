package com.ajay.jpa.hibernate.demo;

import com.ajay.jpa.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();

	//	configuration.addAnnotatedClass(Student.class);
		configuration.addPackage("com.jpa.hibernate.demo.entity");

		StandardServiceRegistryBuilder builder =
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

	}

}
