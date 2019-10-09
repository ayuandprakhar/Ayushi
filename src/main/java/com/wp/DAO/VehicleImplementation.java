package com.wp.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.entities.Transporter;
import com.wp.entities.Vehicles;
@Repository
public class VehicleImplementation implements VehicleDAOInterface {
	@Autowired
	private SessionFactory sessionfactory;

	public void addVehicle(Vehicles v) {
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(v);
		tr.commit();
		session.close();
	
		
	}

	public void removeVehicle(String v_id) {

		Session session = sessionfactory.openSession();
		Vehicles v = session.get(Vehicles.class, v_id);
		Transaction tr = session.beginTransaction();
		session.delete(v);
		tr.commit();
		session.close();
		
		
	}

	public void updateVehicle(Vehicles v) {
		Session session = sessionfactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(v);
		tr.commit();
		session.close();
		
	}

	public Vehicles getVehicle(String v_id) {
		Session session = sessionfactory.openSession();
		Vehicles v = session.get(Vehicles.class, v_id);
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return v;
	}

	public List<Vehicles> getAllVehicle(String email) {
		Session session = sessionfactory.openSession();
		Criteria cr = session.createCriteria(Vehicles.class);
		Criterion c= Restrictions.eq("transporter.t_email_id", email);
	    cr.add(c);
		List<Vehicles> v= cr.list();
		if(v==null) {
			System.out.println("Empty");
		}
		session.close();
		return v;
	}

	public Map<String, String> getId(String email) {
		Session session = sessionfactory.openSession();
		Criteria cr = session.createCriteria(Vehicles.class);
		Criterion c= Restrictions.eq("transporter.t_email_id", email);
		cr.add(c);
		List<Vehicles> v= cr.list();
		Map<String, String> map= new HashMap<String, String>();
		for(Vehicles vehicle: v) {
			String key= vehicle.getV_no();
			String value= vehicle.getV_model();
			map.put(key, value);
			
		}
		return map;
	}

	public List<Vehicles> getAllVehicles() {
		Session session = sessionfactory.openSession();
		Criteria cr = session.createCriteria(Vehicles.class);
		List<Vehicles> v = cr.list();
		session.close();
		return v;
	}
}
