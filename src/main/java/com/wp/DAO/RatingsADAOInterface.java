package com.wp.DAO;

public interface RatingsADAOInterface {
	
	public void rateTransporter(int r_value, String email);
	public int getRatings(String email);

}
