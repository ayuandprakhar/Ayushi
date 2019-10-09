package com.wp.DAO;

import java.util.List;

import com.wp.entities.Transporter;

public interface TransporterDAOInterface {
	public void addTransporter(Transporter t);
	public void removeTransporter(String email);
	public void updateTransporter(Transporter t);
	public Transporter getTransporter(String t_id);
	public List<Transporter> getAllTransporter();
	public Transporter verifyTransporter(Transporter t);
	

}
