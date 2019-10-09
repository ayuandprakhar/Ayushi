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
	private VehicleServiceInterface vservice;
	@RequestMapping("addvehicle")
	public ModelAndView insertVehicle() {
		ModelAndView mv = new ModelAndView("addVehicle");
		mv.addObject("vehicle", new Vehicles());
		return mv;
	}
	@RequestMapping("vehiclelist")
	public ModelAndView showvehicle(@SessionAttribute("email") String email) {
		List<Vehicles> v = vservice.getAllVehicle(email);
		ModelAndView mv = new ModelAndView("vehicleadmin");
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
		v.setVerify(false);
		vservice.addVehicle(v);
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}	
	@RequestMapping("LoadVehicle")
	public void readImage(@RequestParam("number") String v, HttpServletResponse response) {
		Vehicles vl =vservice.getVehicle(v);
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
	@RequestMapping("updatevehicle")
	public ModelAndView updateVehicle(@RequestParam("number") String v_id) {
		Vehicles vehicle= vservice.getVehicle(v_id);
		ModelAndView mv = new ModelAndView("updateVehicle");
		mv.addObject("vehicle", vehicle);
		return mv;

	}
@RequestMapping("updates")
public ModelAndView update(@ModelAttribute("vehicle") Vehicles vehicle, @RequestParam("image1") MultipartFile file) throws Exception
{
	byte[] b = file.getBytes();
	Blob blob = BlobProxy.generateProxy(b);
	vehicle.getV_rc();
	vehicle.setVerify(false);
	vservice.updateVehicle(vehicle);
	
	ModelAndView mv= new ModelAndView("updatesuccess");
	mv.addObject("vehicle", vehicle);
	return mv;
}
@RequestMapping("deletevehicle")
public ModelAndView deletevehicle(@RequestParam("number") String v_id) {
	
	vservice.removeVehicle(v_id);
	ModelAndView mv= new ModelAndView("redirect:vehiclelist");
	return mv;
}

}


