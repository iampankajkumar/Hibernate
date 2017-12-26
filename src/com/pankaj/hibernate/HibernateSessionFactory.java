package com.pankaj.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory = null;

	public static Session getSession() {

		if (sessionFactory == null) {
			createSessionFactory();
		}

		return sessionFactory.openSession();
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			createSessionFactory();
		}
		return sessionFactory;
	}

	private static void createSessionFactory() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
}
