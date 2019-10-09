package com.wp.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.entities.Transporter;
import com.wp.entities.Users;
import com.wp.entities.Vehicles;
@Repository
public class TransporterImplementation implements TransporterDAOInterface {
	@Autowired
	private SessionFactory sessionfactory;

	public void addTransporter(Transporter t) {
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(t);
		tr.commit();
		session.close();

	}

	public void removeTransporter(String email) {
		Session session = sessionfactory.openSession();
		Transporter t = session.get(Transporter.class, email);
		Transaction tr = session.beginTransaction();
		session.delete(t);
		tr.commit();
		session.close();

	}

	public void updateTransporter(Transporter t) {
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(t);
		tr.commit();
		session.close();

	}

	public Transporter getTransporter(String t_id) {
		Session session = sessionfactory.openSession();
		Transporter t = session.get(Transporter.class, t_id);
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return t;
	}

	public List<Transporter> getAllTransporter() {
		Session session = sessionfactory.openSession();
		Criteria cr = session.createCriteria(Transporter.class);
		List<Transporter> t = cr.list();
		session.close();
		return t;
	}

	public Transporter verifyTransporter(Transporter t) {
		
		Session session=sessionfactory.openSession();
		Transporter t1= session.get(Transporter.class, t.getT_email_id());
		if(t1==null) {
			return null;
		}
		else {
			if(t.getT_password().equals(t1.getT_password())) {
				return t1;
			}else {
		
		return null;
			}
		}
	}

}
