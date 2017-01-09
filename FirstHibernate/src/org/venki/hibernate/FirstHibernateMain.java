package org.venki.hibernate;

import models.UserDetails;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FirstHibernateMain {
	
	public static void main(String[] args) {
		
		UserDetails userDetails = new UserDetails("venkatesh");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(userDetails);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	

}
