package com.wp.DAO;

import java.util.List;

import com.wp.entities.Deals;

public interface DealDAOInterface {
	
	public void adddeal(Deals deal);
	public void removedeal(String d_no);
	public List<Deals> getAllDeal();
	public List<Deals> getDealByTransporter(String email);
	public Deals getDealsByDealNo(String d_no);
	

}
