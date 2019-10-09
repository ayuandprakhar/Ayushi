package com.wp.DAO;

import java.util.List;

import com.wp.entities.Ratings;

public interface RatingsADAOInterface {
	
	public void rateTransporter(int r_value, String email);
	public int getRatings(String email);
	public List<Ratings> getAllRatings();

}
