package com.wp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Deals {

	@Id
	private String d_no;
	private String d_description;
	private String d_from_city;
	private String d_to_city;
	private String d_price;
	private Date date;

	@OneToOne
	Vehicles vehicle;

	@ManyToOne
	Transporter transporter;

	public String getD_no() {
		return d_no;
	}

	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public String getD_description() {
		return d_description;
	}

	public void setD_description(String d_description) {
		this.d_description = d_description;
	}

	public String getD_from_city() {
		return d_from_city;
	}

	public void setD_from_city(String d_from_city) {
		this.d_from_city = d_from_city;
	}

	public String getD_to_city() {
		return d_to_city;
	}

	public void setD_to_city(String d_to_city) {
		this.d_to_city = d_to_city;
	}

	public String getD_price() {
		return d_price;
	}

	public void setD_price(String d_price) {
		this.d_price = d_price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public Deals(String d_no, String d_description, String d_from_city, String d_to_city, String d_price, Date date,
			Vehicles vehicle, Transporter transporter) {
		super();
		this.d_no = d_no;
		this.d_description = d_description;
		this.d_from_city = d_from_city;
		this.d_to_city = d_to_city;
		this.d_price = d_price;
		this.date = date;
		this.vehicle = vehicle;
		this.transporter = transporter;
	}

	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Deals() {
		super();
	}

}
