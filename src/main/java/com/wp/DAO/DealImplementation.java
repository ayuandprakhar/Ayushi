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
import com.wp.entities.Transporter;
@Repository
public class DealImplementation implements DealDAOInterface {
	@Autowired
	SessionFactory sessionfactory;

	public void adddeal(Deals deal) {
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(deal);
		tr.commit();
		session.close();

	}

	public void removedeal(String d_no) {
		Session session = sessionfactory.openSession();
		Deals d= session.get(Deals.class,d_no);
		Transaction tr = session.beginTransaction();
		session.delete(d);
		tr.commit();
		session.close();


	}

	public List<Deals> getAllDeal() {
		Session session = sessionfactory.openSession();
		Criteria cr = session.createCriteria(Deals.class);
		List<Deals> d = cr.list();
		session.close();
		return d;
	}

	public List<Deals> getDealByTransporter(String email) {
	   Session session= sessionfactory.openSession();
	   Criteria cr= session.createCriteria(Deals.class);
	   Criterion c= Restrictions.eq("vehicle.transporter.t_email_id",email);
	   cr.add(c);
	   List<Deals> d= cr.list();
	   session.close();
	   return d;
	   
	}

	public Deals getDealsByDealNo(String d_no) {
		Session session= sessionfactory.openSession();
	    Transaction tr= session.beginTransaction();
	    Deals d= session.get(Deals.class, d_no);
	    tr.commit();
	    session.close();
		return d;
	}

}
