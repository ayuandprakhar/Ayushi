package com.wp.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Deals;
import com.wp.entities.Users;
import com.wp.services.DealServiceInterface;
import com.wp.services.UserServiceInterface;
import com.wp.services.VehicleServiceInterface;

@Controller
public class DealController {
	@Autowired
	private DealServiceInterface de;
	
	@Autowired
	private UserServiceInterface ue;
	
	@Autowired
	private VehicleServiceInterface ve;
	@Autowired
	JavaMailSender mailSender;
	
	@RequestMapping("postDeal")
	public ModelAndView adddeal(@SessionAttribute("email") String email) {
		ModelAndView mv = new ModelAndView("postdeal");
		mv.addObject("Deals", new Deals());
		Map<String, String> v_nos= ve.getId(email);
		mv.addObject("v_nos", v_nos);
		return mv;

	}
	@RequestMapping("adddeal")
	public ModelAndView insertdeal(@ModelAttribute("Deals") Deals deal) {
		de.adddeal(deal);	
	    sendEmail();   
		ModelAndView mv= new ModelAndView("redirect:showall");
	    return mv;
		
	}
	@RequestMapping("showall")
	public ModelAndView showall(@ModelAttribute("Deals") Deals deal){
		List<Deals> deals= de.getAllDeal();
		ModelAndView mv= new ModelAndView("viewdeals");
		mv.addObject("deals", deals);
		return mv;
		
		
	}
    
	public void sendEmail(){
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		List<Users> list =ue.getAllMails();
		String[] to=Arrays.copyOf(list.toArray(), list.toArray().length,String[].class);
		mailMessage.setTo(to);
		String subject="New Deal";
		mailMessage.setSubject(subject);
		String message="New Deal posted by transporter";
		mailMessage.setText(message);
		mailSender.send(mailMessage);
	}
	
	
	
	
	
	

}
