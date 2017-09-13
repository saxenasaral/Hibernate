package com.saral.training.criteriaApi.dto;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionfactory.openSession();
		session.beginTransaction();

		UserDetailsCriteriaApi user = null;

		/*for (int i = 0; i < 10; i++) {
			user = new UserDetailsCriteriaApi();
			user.setUserName("user" + i);
			session.save(user);
		}*/
		
		/*  Restriction Criteria
		 * Criteria criteria = session.createCriteria(UserDetailsCriteriaApi.class);
		criteria.add(Restrictions.eq("userName", "user7"))
				.add(Restrictions.gt("userId", 5));*/
		
		
		Criteria criteria = session.createCriteria(UserDetailsCriteriaApi.class)
				.setProjection(Projections.count("userId"))
				.addOrder(Order.desc("userId"));
		
		
		
		List<UserDetailsCriteriaApi> list = criteria.list();
		for(UserDetailsCriteriaApi users: list){
			System.out.println("users "+users.getUserName());
		}

		session.getTransaction().commit();
		session.close();
	}

}
