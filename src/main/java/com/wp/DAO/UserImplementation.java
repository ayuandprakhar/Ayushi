package com.wp.DAO;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.entities.Transporter;
import com.wp.entities.Users;
@Repository
public class UserImplementation implements UserDAOInterface{
	
	@Autowired
	private SessionFactory sessionfactoy;

	public void addUser(Users u) {
		Session session = sessionfactoy.openSession();
		Transaction tr = session.beginTransaction();
		session.save(u);
		tr.commit();
		session.close();
		
	}

	public void removeUser(String email) {
		Session session = sessionfactoy.openSession();
		Users u = session.get(Users.class, email);
		Transaction tr = session.beginTransaction();
		session.delete(u);
		tr.commit();
		session.close();
		
	}

	public void updateUser(Users u) {
		Session session = sessionfactoy.openSession();
		Transaction tr = session.beginTransaction();
		session.update(u);
		tr.commit();
		session.close();
	}

	public Users getUser(String email) {
		Session session = sessionfactoy.openSession();
		Users u = session.get(Users.class, email);
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return u;
	}

	public List<Users> getAllUser() {
		Session session = sessionfactoy.openSession();
		Criteria cr = session.createCriteria(Users.class);
		List<Users> u = cr.list();
		session.close();
		return u;
	}

	public Users verifyUser(Users u) {
		Session session=sessionfactoy.openSession();
		Users u1= session.get(Users.class, u.getU_emailid());
		if(u1==null) {
			return null;
		}
		else {
			if(u.getU_password().equals(u1.getU_password())) {
				return u1;
			}else 
		
		return null;
		}
	}

	public List<Users> getAllMails() {
		  Session session = sessionfactoy.openSession();
			Criteria cr= session.createCriteria(Users.class);
			ProjectionList projection = Projections.projectionList();
			projection.add(Projections.property("u_emailid"));
			cr.setProjection(projection);
			List<Users> user=cr.list();
			return user;
		
	}

}
