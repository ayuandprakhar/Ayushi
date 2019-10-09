package com.wp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.DAO.RatingsADAOInterface;
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

}
