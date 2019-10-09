package com.wp.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.entities.Deals;
import com.wp.entities.Ratings;
import com.wp.entities.Transporter;
@Repository
public class RatingsImplementation implements RatingsADAOInterface {

	@Autowired
	SessionFactory sessionFactory;

	public void rateTransporter(int r_value, String email) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Transporter trans = session.get(Transporter.class, email);
		if (trans.getRatings() != null) {
			
			int r_id = trans.getRatings().getR_id();
			Ratings rate = session.get(Ratings.class, r_id);
			r_value = (rate.getR_value() + r_value) / 2;
			rate.setR_value(r_value);
			int counter = rate.getR_counter() + 1;
			rate.setR_counter(counter);
			session.saveOrUpdate(rate);
		} else {
			Ratings rate = new Ratings();
			rate.setR_counter(1);
			rate.setR_value(r_value);
			rate.setTransporter(new Transporter(email));
			session.save(rate);

		}
		tr.commit();
		session.close();

	}

	public int getRatings(String email) {
		return 0;

	}

	public List<Ratings> getAllRatings() {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Ratings.class);
		List<Ratings> rating = cr.list();
		session.close();
		return rating;
	}

}
