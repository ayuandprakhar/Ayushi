package com.wp.controllers;

import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.DAO.VehicleDAOInterface;
import com.wp.entities.Transporter;
import com.wp.entities.Vehicles;
import com.wp.services.VehicleServiceInterface;

@Controller
public class VehicleController {

	@Autowired
	private VehicleServiceInterface vehicle;
	@RequestMapping("addvehicle")
	public ModelAndView insertVehicle() {
		ModelAndView mv = new ModelAndView("addVehicle");
		mv.addObject("vehicle", new Vehicles());
		return mv;
	}
	@RequestMapping("vehiclelist")
	public ModelAndView showvehicle(@SessionAttribute("email") String email) {
		List<Vehicles> v = vehicle.getAllVehicle(email);
		ModelAndView mv = new ModelAndView("viewvehicle");
		mv.addObject("vehicle", v);
		return mv;
	}
	@RequestMapping("addVehicle1")
	public ModelAndView enterUser(@ModelAttribute("vehicle") Vehicles v, @RequestParam("image") MultipartFile file,
			@SessionAttribute("email") String email) throws Exception {
		Transporter trans = new Transporter();
		trans.setT_email_id(email);
		v.setTransporter(trans);

		byte[] b = file.getBytes();
		Blob blob = BlobProxy.generateProxy(b);
		v.setV_rc(blob);
		vehicle.addVehicle(v);
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}	
	@RequestMapping("LoadVehicle")
	public void readImage(@RequestParam("number") String v, HttpServletResponse response) {
		Vehicles vl =vehicle.getVehicle(v);
		Blob bl =vl.getV_rc();
		byte[] b = null;
		try {
			b = bl.getBytes(1, (int) bl.length());
			ServletOutputStream out = response.getOutputStream();
			out.write(b);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}


