package com.wp.controllers;

import java.io.IOException;
import java.sql.Blob;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Transporter;
import com.wp.entities.Users;
import com.wp.services.TransporterServiceInterface;

@Controller
public class TransporterController {

	@Autowired
	private TransporterServiceInterface service;

	@RequestMapping("addTransporter")
	public ModelAndView insertTrans(@ModelAttribute("Transporter") Transporter port) {
		ModelAndView mv = new ModelAndView("insertTransporter");
		return mv;

	}
	@RequestMapping("inserttransporter")
	public ModelAndView enterUser(@ModelAttribute("Transporter") Transporter port,
			@RequestParam("image1") MultipartFile file) throws Exception {
		byte[] b = file.getBytes();
		Blob blob = BlobProxy.generateProxy(b);
		port.setImage(blob);
		port.setVerify(false);
		service.addTransporter(port);
		ModelAndView mv = new ModelAndView("viewuser");
		return mv;
	}
	@RequestMapping("LoadImage")
	public void readImage(@RequestParam("t_id") String t_id, HttpServletResponse response) {
		Transporter tm = service.getTransporter(t_id);
		Blob bl = tm.getImage();
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
	@RequestMapping("updatetransporter")
	public ModelAndView updateTransporter(@SessionAttribute("email") String email) {
		Transporter transporter = service.getTransporter(email);
		ModelAndView mv = new ModelAndView("updateTransporter");
		mv.addObject("transporters", transporter);
		return mv;

	}
	@RequestMapping("new")
	public ModelAndView update(@ModelAttribute("transporter") Transporter transporter, @RequestParam("image1") MultipartFile file) throws Exception
	{
		byte[] b = file.getBytes();
		Blob blob = BlobProxy.generateProxy(b);
		transporter.getImage();
		service.updateTransporter(transporter);
		
		ModelAndView mv= new ModelAndView("viewtransporter");
		mv.addObject("transporters", transporter);
		return mv;
	}

}
