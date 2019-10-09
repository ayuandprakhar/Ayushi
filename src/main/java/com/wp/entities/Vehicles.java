package com.wp.entities;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehicles {

	@Id
	private String v_no;
	private String v_model;
	private String v_type;
	private Blob v_rc;
	public boolean verify;
	@ManyToOne()
	Transporter transporter;

	@OneToOne(mappedBy="vehicle",orphanRemoval=true, cascade = CascadeType.PERSIST)
	Deals deal;

	public String getV_no() {
		return v_no;
	}

	public void setV_no(String v_no) {
		this.v_no = v_no;
	}

	public String getV_model() {
		return v_model;
	}

	public void setV_model(String v_model) {
		this.v_model = v_model;
	}

	public String getV_type() {
		return v_type;
	}

	public void setV_type(String v_type) {
		this.v_type = v_type;
	}

	public Blob getV_rc() {
		return v_rc;
	}

	public void setV_rc(Blob v_rc) {
		this.v_rc = v_rc;
	}

	public Vehicles(String v_no, String v_model, String v_type, Blob v_rc, boolean verify, Transporter transporter,
			Deals deal) {
		super();
		this.v_no = v_no;
		this.v_model = v_model;
		this.v_type = v_type;
		this.v_rc = v_rc;
		this.verify = verify;
		this.transporter = transporter;
		this.deal = deal;
	}

	public Deals getDeal() {
		return deal;
	}

	public void setDeal(Deals deal) {
		this.deal = deal;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

	public Transporter getTransporter() {
		return transporter;
	}

	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}

	public Vehicles(String v_no, String v_model, String v_type, Blob v_rc, Deals deal, Transporter transporter) {
		super();
		this.v_no = v_no;
		this.v_model = v_model;
		this.v_type = v_type;
		this.v_rc = v_rc;
		this.deal = deal;
		this.transporter = transporter;
	}

	public Vehicles() {
		super();
	}

}
