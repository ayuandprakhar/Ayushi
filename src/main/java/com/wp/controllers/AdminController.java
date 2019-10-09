package com.wp.controllers;

import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Ratings;
import com.wp.entities.Transporter;
import com.wp.entities.Vehicles;
import com.wp.services.RatingsServiceInterface;
import com.wp.services.TransporterServiceInterface;
import com.wp.services.UserServiceInterface;
import com.wp.services.VehicleServiceInterface;

@Controller
public class AdminController {
	@Autowired
	private TransporterServiceInterface tservice;
	@Autowired
	private UserServiceInterface uservice;
	@Autowired
	private RatingsServiceInterface rservice;
	@Autowired
	private VehicleServiceInterface vservice;

	@RequestMapping("viewtransporter")
	public ModelAndView viewt() {

		List<Transporter> transporters = tservice.getAllTransporter();
		ModelAndView mv = new ModelAndView("transporterlist");
		mv.addObject("transporters", transporters);
		return mv;
	}

	@RequestMapping("showimage")
	public void readImage(@RequestParam("number") String number, HttpServletResponse response) {
		Transporter transporter = tservice.getTransporter(number);
		Blob blob = transporter.getImage();
		try {
			byte[] b = null;
			b = blob.getBytes(1, (int) blob.length());
			ServletOutputStream sos = response.getOutputStream();
			sos.write(b);
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("approvetransporter")
	public ModelAndView approve(@RequestParam("number") String number) {
		Transporter trans = tservice.getTransporter(number);
		trans.setVerify(true);
		tservice.updateTransporter(trans);
		ModelAndView mv = new ModelAndView("redirect:viewtransporter");
		return mv;
	}

	@RequestMapping("rejecttransporter")
	public ModelAndView reject(@RequestParam("number") String number) {
		Transporter trans = tservice.getTransporter(number);
		trans.setVerify(false);
		tservice.updateTransporter(trans);
		ModelAndView mv = new ModelAndView("redirect:viewtransporter");
		return mv;
	}

	@RequestMapping("deletetransporter")
	public ModelAndView deletetransporter(@RequestParam("number") String email) {
		tservice.removeTransporter(email);
		ModelAndView mv = new ModelAndView("viewtransporter");
		return mv;
	}

	@RequestMapping("ratings")
	public ModelAndView viewrating() {
		List<Ratings> rate = rservice.getAllRatings();
		ModelAndView mv = new ModelAndView("viewratings");
		mv.addObject("rating", rate);
		return mv;

	}

	@RequestMapping("viewvehicles")
	public ModelAndView viewv() {

		List<Vehicles> vehicle = vservice.getAllVehicles();
		ModelAndView mv = new ModelAndView("viewvehicle");
		mv.addObject("vehicle", vehicle);
		return mv;
	}

	@RequestMapping("approvevehicle")
	public ModelAndView approvevehicle(@RequestParam("number") String number) {
		Vehicles v = vservice.getVehicle(number);
		v.setVerify(true);
		vservice.updateVehicle(v);
		ModelAndView mv = new ModelAndView("redirect:viewvehicles");
		return mv;

	}

	@RequestMapping("rejectvehicle")
	public ModelAndView rejectvehicle(@RequestParam("number") String number) {
		Vehicles v = vservice.getVehicle(number);
		v.setVerify(false);
		vservice.updateVehicle(v);
		ModelAndView mv = new ModelAndView("redirect:viewvehicles");
		return mv;

	}

}
