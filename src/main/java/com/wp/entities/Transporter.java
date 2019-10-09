package com.wp.entities;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transporter {
	@Id
	private String t_email_id;
	private String t_id;
	private String t_firm_name;
	private String t_password;
	private String t_mobile;
	private String t_pan_no;
	private String t_gst_no;
	private Blob image;
	public boolean verify;
	
	@OneToMany(mappedBy = "transporter",orphanRemoval=true, cascade = CascadeType.PERSIST)
	private List<Vehicles> vehicle = new ArrayList<Vehicles>();

	@OneToMany(mappedBy = "transporter",orphanRemoval=true, cascade = CascadeType.PERSIST)
	private List<Deals> deal = new ArrayList<Deals>();

	@OneToMany(mappedBy = "transporter",orphanRemoval=true, cascade = CascadeType.PERSIST)
	private List<Queries> query = new ArrayList<Queries>();
	
	@OneToOne(mappedBy = "transporter", orphanRemoval=true, cascade = CascadeType.PERSIST)
	private Ratings ratings;

	
	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	public String getT_id() {
		return t_id;
	}

	public void setT_id(String t_id) {
		this.t_id = t_id;
	}

	public String getT_firm_name() {
		return t_firm_name;
	}

	public void setT_firm_name(String t_firm_name) {
		this.t_firm_name = t_firm_name;
	}

	public String getT_email_id() {
		return t_email_id;
	}

	public void setT_email_id(String t_email_id) {
		this.t_email_id = t_email_id;
	}

	public String getT_password() {
		return t_password;
	}

	public void setT_password(String t_password) {
		this.t_password = t_password;
	}

	public String getT_mobile() {
		return t_mobile;
	}

	public void setT_mobile(String t_mobile) {
		this.t_mobile = t_mobile;
	}

	public String getT_pan_no() {
		return t_pan_no;
	}

	public void setT_pan_no(String t_pan_no) {
		this.t_pan_no = t_pan_no;
	}

	public String getT_gst_no() {
		return t_gst_no;
	}

	public void setT_gst_no(String t_gst_no) {
		this.t_gst_no = t_gst_no;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public List<Vehicles> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicles> vehicle) {
		this.vehicle = vehicle;
	}

	public List<Deals> getDeal() {
		return deal;
	}

	public void setDeal(List<Deals> deal) {
		this.deal = deal;
	}

	public List<Queries> getQuery() {
		return query;
	}

	public void setQuery(List<Queries> query) {
		this.query = query;
	}
	
	

	public Ratings getRatings() {
		return ratings;
	}

	public void setRatings(Ratings ratings) {
		this.ratings = ratings;
	}

	public Transporter(String t_email_id) {
		super();
		this.t_email_id = t_email_id;
	}

	public Transporter(String t_email_id, String t_id, String t_firm_name, String t_password, String t_mobile,
			String t_pan_no, String t_gst_no, Blob image, boolean verify, List<Vehicles> vehicle, List<Deals> deal,
			List<Queries> query, Ratings ratings) {
		super();
		this.t_email_id = t_email_id;
		this.t_id = t_id;
		this.t_firm_name = t_firm_name;
		this.t_password = t_password;
		this.t_mobile = t_mobile;
		this.t_pan_no = t_pan_no;
		this.t_gst_no = t_gst_no;
		this.image = image;
		this.verify = verify;
		this.vehicle = vehicle;
		this.deal = deal;
		this.query = query;
		this.ratings = ratings;
	}
	
	
	
	public Transporter(String t_email_id, String t_id, String t_firm_name, String t_password, String t_mobile,
			String t_pan_no, String t_gst_no, Blob image, boolean verify, List<Vehicles> vehicle, List<Deals> deal,
			List<Queries> query) {
		super();
		this.t_email_id = t_email_id;
		this.t_id = t_id;
		this.t_firm_name = t_firm_name;
		this.t_password = t_password;
		this.t_mobile = t_mobile;
		this.t_pan_no = t_pan_no;
		this.t_gst_no = t_gst_no;
		this.image = image;
		this.verify = verify;
		this.vehicle = vehicle;
		this.deal = deal;
		this.query = query;
	}

	public Transporter() {
		super();
	}

	
}
