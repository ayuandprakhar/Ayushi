package com.wp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ratings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int r_id;
	private int r_value;
	private int r_counter;
	
	@OneToOne
	private Transporter transporter;

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public int getR_value() {
		return r_value;
	}

	public void setR_value(int r_value) {
		this.r_value = r_value;
	}

	public int getR_counter() {
		return r_counter;
	}

	public void setR_counter(int r_counter) {
		this.r_counter = r_counter;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Ratings(int r_id, int r_value, int r_counter, Transporter transporter) {
		super();
		this.r_id = r_id;
		this.r_value = r_value;
		this.r_counter = r_counter;
		this.transporter = transporter;
	}

	public Ratings() {
		super();
	}
	
	
	
	
	
	
	
	

}
