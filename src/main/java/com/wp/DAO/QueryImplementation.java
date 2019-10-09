package com.wp.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.entities.Deals;
import com.wp.entities.Queries;

@Repository
public class QueryImplementation implements QueryDAOInterface {
	@Autowired
	SessionFactory sessionfactory;

	public void addquery(Queries query) {
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(query);
		tr.commit();
		session.close();
	}

	public List<Queries> getQueryByTransporter(String email) {
		Session session = sessionfactory.openSession();
		Criteria cr = session.createCriteria(Queries.class);
		Criterion c = Restrictions.eq("user.u_emailid", email);
		cr.add(c);
		List<Queries> d = cr.list();
		session.close();
		return d;

	}

	public void updatequery(Queries query) {
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(query);
		tr.commit();
		session.close();

	}

	public List<Queries> getresponse(String email) {
		Session session = sessionfactory.openSession();
		Criteria cr = session.createCriteria(Queries.class);
		Criterion c = Restrictions.eq("transporter.t_email_id", email);
		cr.add(c);
		List<Queries> l = cr.list();
		session.close();
		return l;

	}

	public Queries getQueryByNo(String q_id) {
		Session session= sessionfactory.openSession();
		Transaction tr= session.beginTransaction();
		Queries query= session.get(Queries.class, q_id);
		tr.commit();
		session.close();
		return query;
	}

}
