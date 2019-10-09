package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wp.entities.Transporter;

public interface TransporterServiceInterface {
	public void addTransporter(Transporter t);

	public void removeTransporter(String email);

	public void updateTransporter(Transporter t);

	public Transporter getTransporter(String email);

	public List<Transporter> getAllTransporter();
	public Transporter verifyTransporter(Transporter t);

}
