package com.icr7.hibernate.users;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.icr7.entity.UserInfo;

public class CreateUser {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserInfo.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			// create a student object
			System.out.println("enter number of data:");
			int n = sc.nextInt();
			sc.nextLine();
			UserInfo[] TempUser=new UserInfo[n];
			for (int i = 0; i < n; i++) {
				System.out.print("user name: ");
				String u = sc.nextLine();
				System.out.print("password : ");
				String p = sc.nextLine();

				TempUser[i] = new UserInfo(u, p);
				
				session.save(TempUser[i]);

			}
			
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
