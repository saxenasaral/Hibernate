package com.saral.training.hql.dto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		UserDetailsHQL user = null;
		/*
		 * for (int i = 0; i < 10; i++) { user = new UserDetailsHQL();
		 * user.setUserName("user" + i); session.save(user); }
		 */

		/*
		 * using parameter binding
		 * 
		 * 
		 * 
		 * String val="5"; String val1="user9"; Query query =
		 * session.createQuery
		 * ("from UserDetailsHQL where userId > ? and userName=?");
		 * query.setInteger(0, Integer.parseInt(val)); query.setString(1, val1);
		 * query.setFirstResult(5); query.setMaxResults(3);
		 * 
		 * List<String> userList = query.list(); //for(St userEn: userList){
		 * System.out.println("user is :"+ userList); //}
		 */

		// using named query

		Query queryNamed = session.getNamedQuery("userby.id");
		queryNamed.setInteger(0, 5);

		List<UserDetailsHQL> list = queryNamed.list();
		for (UserDetailsHQL userEn : list) {
			System.out.println("user is :" + userEn.getUserName());
		}
		session.getTransaction().commit();
		session.close();

	}

}
