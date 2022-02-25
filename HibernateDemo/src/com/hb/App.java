package com.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hb.entity.Users1;


public class App{
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                  .configure("hibernate.cfg.xml")
				                  .addAnnotatedClass(Users1.class)
				                  .buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
	
			
			//create Object of entity class type
		//	Users1 user = new Users1("username","password","firstName","lastName");
			
			
			Users1 user = new Users1();
			//start transcation
			session.beginTransaction();
			//perform operation
			//session.save(user);
			
			user = session.get(Users1.class, 3);
			
			//updating object
			user.setUsername("deva");
			user.setPassword("raja");
			user.setFirstName("rani");
			user.setLastName("devi");
			//commit the Transaction
			
		//	session.getTransaction().commit();
			System.out.println("Row added!");
//		Users1	users = new Users1("rama","sitha","laxmana","urmila");
//		  session.save(users);
			System.out.println("row 2 added !");
	
	
			
			//start trsnscation
		//	session.beginTransaction();
			
/*		List<Users1> user1 =	session.createQuery("from users1").getResultList();
			
		for(Users1 temp :user1) {
			System.out.println(temp);
		}
			
	*/		//commit the transaction
			
			session.getTransaction().commit();
			
			
			
			
			
		}finally {
			session.close();
			factory.close();
		}
		
		
	}

}