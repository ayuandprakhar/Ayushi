package com.wp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Queries {
	@Id
	private String q_id;
	private String q_description;
	private String q_response;

	@ManyToOne()
	Users user;

	@ManyToOne()
	Transporter transporter;

	public Queries() {
		super();
	}


	public Queries(String q_id, String q_description, String q_response, Users user, Transporter transporter) {
		super();
		this.q_id = q_id;
		this.q_description = q_description;
		this.q_response = q_response;
		this.user = user;
		this.transporter = transporter;
	}

	
	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Transporter getTransporter() {
		return transporter;
	}


	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}


	public String getQ_id() {
		return q_id;
	}

	public void setQ_id(String q_id) {
		this.q_id = q_id;
	}

	public String getQ_description() {
		return q_description;
	}

	public void setQ_description(String q_description) {
		this.q_description = q_description;
	}

	public String getQ_response() {
		return q_response;
	}

	public void setQ_response(String q_response) {
		this.q_response = q_response;
	}

}
