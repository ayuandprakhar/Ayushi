package com.wp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wp.services.RatingsServiceInterface;

@Controller
public class RatingController {

	@Autowired
	RatingsServiceInterface rservice;

	@RequestMapping("rateTransporter")
	//@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity rate(@RequestParam("transporterid") String email, @RequestParam("ratingValue") int value) {
		rservice.rateTransporter(value, email);
		return new ResponseEntity(HttpStatus.OK);

	}

}
