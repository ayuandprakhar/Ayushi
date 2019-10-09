package com.wp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.DAO.RatingsADAOInterface;
import com.wp.entities.Ratings;
@Service
public class RatingsServiceImplemenation implements RatingsServiceInterface {

	@Autowired
	RatingsADAOInterface ratings;

	public void rateTransporter(int r_value, String email) {

		ratings.rateTransporter(r_value, email);
	}

	public int getRatings(String email) {

		return ratings.getRatings(email);
	}

	public List<Ratings> getAllRatings() {
		return  ratings.getAllRatings();
	}

}
