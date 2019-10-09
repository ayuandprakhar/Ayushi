package com.wp.services;

public interface RatingsServiceInterface {
	
	public void rateTransporter(int r_value, String email);
	public int getRatings(String email);

}
