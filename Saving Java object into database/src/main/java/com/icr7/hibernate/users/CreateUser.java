package com.icr7.hibernate.users;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.icr7.entity.UserInfo;

public class CreateUser {
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory  factory = new Configuration()
								  .configure("hibernate.cfg.xml")
								  .addAnnotatedClass(UserInfo.class)
								  .buildSessionFactory();
		//create session
		Session session=factory.getCurrentSession();
		
		try {
			//create a student object
			System.out.println("creating new student object....");
			UserInfo TempUser = new UserInfo("ishwar","icr7");
			
			//start a transaction
	        session.beginTransaction();
			
			//save the student object
		    System.out.println("Saving the student...");
			session.save(TempUser);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
		
		
		
		
	}

}
