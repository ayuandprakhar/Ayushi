package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.DAO.DealDAOInterface;
import com.wp.entities.Deals;

@Service
public class DealServiceImplementation implements DealServiceInterface {
	@Autowired
	DealDAOInterface d;

	public void adddeal(Deals deal) {
		d.adddeal(deal);
	}

	public void removedeal(String d_no) {
		d.removedeal(d_no);

	}

	public List<Deals> getAllDeal() {
		return d.getAllDeal();
	}

	public List<Deals> getDealByTransporter(String email) {
		return d.getDealByTransporter(email);
	}

	public Deals getDealsByDealNo(String d_no) {
		return d.getDealsByDealNo(d_no);
	}

}
