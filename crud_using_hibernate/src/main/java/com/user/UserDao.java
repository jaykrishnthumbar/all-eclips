package com.user;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {

	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
	private static SessionFactory sf = cfg.buildSessionFactory();

	public static void save(User u) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u);
		tx.commit();

		session.close();

	}

	public static List<User> allEmp() {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		List<User> list = session.createQuery("from User").getResultList();

		tx.commit();
		session.close();
		return list;
	}

	public static void delete(User u) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		session.delete(u);
		tx.commit();
		session.close();
	}

	public static User getUserById(int id) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		User u = (User) session.get(User.class, id);
		tx.commit();
		session.close();
		return u;

	}

	public static void update(User u) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.update(u);
		tx.commit();
		session.close();
	}
	 

}
