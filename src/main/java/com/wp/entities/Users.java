package com.wp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Users {
	@Id
	private String u_emailid;
	private String u_id;
	private String u_name;
	private String u_address;
	private String u_password;
	private String u_number;
	private String u_city;
	private String u_state;
	@OneToMany(mappedBy="user")
	 private List<Queries> query= new ArrayList<Queries>();

	public Users(String u_id, String u_name, String u_address, String u_emailid, String u_password, String u_number,
			String u_city, String u_state) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_address = u_address;
		this.u_emailid = u_emailid;
		this.u_password = u_password;
		this.u_number = u_number;
		this.u_city = u_city;
		this.u_state = u_state;
	}

	public String getU_password() {
		return u_password;
	}

	public Users(String u_id, String u_name, String u_address, String u_emailid, String u_password, String u_number,
			String u_city, String u_state, List<Queries> query) {
		super();
		this.u_id = u_id;
		this.u_name = u_name;
		this.u_address = u_address;
		this.u_emailid = u_emailid;
		this.u_password = u_password;
		this.u_number = u_number;
		this.u_city = u_city;
		this.u_state = u_state;
		this.query = query;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_city() {
		return u_city;
	}

	public void setU_city(String u_city) {
		this.u_city = u_city;
	}

	public String getU_state() {
		return u_state;
	}

	public void setU_states(String u_states) {
		this.u_state = u_state;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public Users() {
		super();
	}

	public void setU_state(String u_state) {
		this.u_state = u_state;
	}

	public String getU_emailid() {
		return u_emailid;
	}

	public void setU_emailid(String u_emailid) {
		this.u_emailid = u_emailid;
	}

	public String getU_number() {
		return u_number;
	}

	public void setU_number(String u_number) {
		this.u_number = u_number;
	}

}
