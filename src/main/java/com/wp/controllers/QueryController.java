package com.wp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Deals;
import com.wp.entities.Queries;
import com.wp.entities.Transporter;
import com.wp.entities.Users;
import com.wp.services.DealServiceInterface;
import com.wp.services.QueryServiceInterface;
import com.wp.services.TransporterServiceInterface;
import com.wp.services.UserServiceInterface;

@Controller
public class QueryController {
	
	@Autowired
	private TransporterServiceInterface tservice;
	@Autowired
	private UserServiceInterface uservice;
	@Autowired
	private QueryServiceInterface qservice;
	@Autowired
	private DealServiceInterface dservice;
	
	@RequestMapping("raisequery")
	public ModelAndView addquery(@RequestParam("number") String d_no){
		Deals d= dservice.getDealsByDealNo(d_no);
		ModelAndView mv= new ModelAndView("query");
		mv.addObject("query", new Queries());
		mv.addObject("deals", d);
        return mv;
		
	}
	@RequestMapping("queryy")
	public ModelAndView raisequery(@ModelAttribute("query")  Queries query,@SessionAttribute("email") String email) {
		
		qservice.addquery(query);
		ModelAndView mv= new ModelAndView("viewuser");
		return mv;
	
	}
	@RequestMapping("respondquery")
	public ModelAndView submitResponse(@ModelAttribute("query") Queries query)
	{
		qservice.updatequery(query);
		ModelAndView mv= new ModelAndView("success");
		return mv;
	}
	@RequestMapping("viewqueries")
	public ModelAndView view(@SessionAttribute("email") String email) {
		Transporter trans= tservice.getTransporter(email);
		List<Queries> query= qservice.getresponse(email);
		ModelAndView mv= new ModelAndView("viewquery");
		mv.addObject("query", query);
		mv.addObject("trans", trans);
		return mv;
	}
	@RequestMapping("raiseresponse")
	public ModelAndView response(@RequestParam("number") String q_id)
	{
		Queries query= qservice.getQueryByNo(q_id);
		ModelAndView mv = new ModelAndView("answer");
		mv.addObject("query", query);
		return mv;
	}
	@RequestMapping("viewresponse")
	public ModelAndView myResponse(@SessionAttribute("email") String email)
	{
		Users user= uservice.getUser(email);
		List<Queries> query=qservice.getQueryByTransporter(email);
		ModelAndView mv = new ModelAndView("answerr");
		mv.addObject("user", user);
		mv.addObject("query", query);
		return mv;
	}
	
	

}
