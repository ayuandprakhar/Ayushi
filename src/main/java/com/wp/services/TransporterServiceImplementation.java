package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.DAO.TransporterDAOInterface;
import com.wp.DAO.TransporterImplementation;
import com.wp.entities.Transporter;

@Service
public class TransporterServiceImplementation implements TransporterServiceInterface {
	@Autowired
	private TransporterDAOInterface transporter;

	public void addTransporter(Transporter t) {
		transporter.addTransporter(t);

	}

	public void removeTransporter(String email) {
		transporter.removeTransporter(email);

	}

	public void updateTransporter(Transporter t) {
		transporter.updateTransporter(t);

	}

	public Transporter getTransporter(String t_id) {
		return transporter.getTransporter(t_id);
	}

	public List<Transporter> getAllTransporter() {
		return transporter.getAllTransporter();
	}

	public Transporter verifyTransporter(Transporter t) {
		return transporter.verifyTransporter(t);
	}

}
