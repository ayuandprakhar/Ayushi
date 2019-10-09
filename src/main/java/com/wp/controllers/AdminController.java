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

import com.wp.entities.Transporter;
import com.wp.services.TransporterServiceInterface;
import com.wp.services.UserServiceInterface;
@Controller
public class AdminController {
	@Autowired
	private TransporterServiceInterface tservice;
	@Autowired
	private UserServiceInterface uservice;
	
	@RequestMapping("viewtransporter")
	public ModelAndView viewt() {
		
		List<Transporter> transporters= tservice.getAllTransporter();
		ModelAndView mv=new ModelAndView("transporterlist");
		mv.addObject("transporters", transporters);
		return mv;
	}
	@RequestMapping("showimage")
	public void readImage(@RequestParam("number") String number,HttpServletResponse response)
	{
		Transporter transporter=tservice.getTransporter(number);
		Blob blob= transporter.getImage();
		try {
		byte[] b= null;
		b= blob.getBytes(1, (int)blob.length());
		ServletOutputStream sos = response.getOutputStream();
		sos.write(b);
		sos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@RequestMapping("approvetransporter")
	public ModelAndView approve(@RequestParam("number") String number) {
		Transporter trans= tservice.getTransporter(number);
		trans.setVerify(true);
		tservice.updateTransporter(trans);
		ModelAndView mv= new ModelAndView("redirect:viewtransporter");
		return mv;	
	}

}
