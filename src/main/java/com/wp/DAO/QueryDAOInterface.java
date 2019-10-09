package com.wp.DAO;

import java.util.List;

import com.wp.entities.Queries;

public interface QueryDAOInterface {
	
	public void addquery(Queries query);
	public void updatequery(Queries query);
	public List<Queries> getresponse(String email);
	public List<Queries> getQueryByTransporter(String email);
	public Queries getQueryByNo(String q_id);
	

}