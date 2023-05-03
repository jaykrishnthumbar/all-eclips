package com.user;

import org.hibernate.cfg.Configuration;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {

	private static Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class);
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

	public static boolean Login(User u) {
		try {
			Session session = sf.openSession();

			Transaction tx = session.beginTransaction();
			User user = UserDao.getUserById(u.getId());
			
			int i = user.getId();
			String p = user.getPassword();
			if (u.getId()== i && u.getPassword().contains(p)) {
				tx.commit();
				session.close();
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
