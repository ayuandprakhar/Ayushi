package com.wp.services;

import java.util.List;

import com.wp.entities.Ratings;

public interface RatingsServiceInterface {
	
	public void rateTransporter(int r_value, String email);
	public int getRatings(String email);
	public List<Ratings> getAllRatings();

}
