package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.DAO.QueryDAOInterface;
import com.wp.entities.Queries;
@Service
public class QueryServiceImplementation implements QueryServiceInterface {
	@Autowired
	QueryDAOInterface qd;

	public void addquery(Queries query) {
		qd.addquery(query);
		
	}
	public void updatequery(Queries query) {
		qd.updatequery(query);

	}
	public List<Queries> getQueryByTransporter(String email) {
		return qd.getQueryByTransporter(email);
	}

	public List<Queries> getresponse(String email) {
		return qd.getresponse(email);

	}
	public Queries getQueryByNo(String q_id) {
		return qd.getQueryByNo(q_id);
	}

}
