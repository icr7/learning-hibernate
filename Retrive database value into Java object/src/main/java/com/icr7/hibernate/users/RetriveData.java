package com.icr7.hibernate.users;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.icr7.entity.UserInfo;

public class RetriveData {
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(UserInfo.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			
			{// query for all user_data
				List<UserInfo> theUsers = session.createQuery("from UserInfo").list();

				// display all the users list
				displayList(theUsers);
			}
			

			{// query for user with name ishwar
				List<UserInfo> theUsers = session.createQuery("from UserInfo u where u.username='ishwar singh' ").list();

				// display user with username ishwar
				displayList(theUsers);
			}

			// commit transaction
			session.getTransaction().commit();


		} finally {
			factory.close();
		}

	}
	

	private static void displayList(List<UserInfo> theUsers) {
		for (UserInfo tempUser : theUsers) {
			System.out.println(tempUser);
		}
	}
	

}
