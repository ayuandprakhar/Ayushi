package com.wp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wp.DAO.UserImplementation;
import com.wp.entities.Users;
import com.wp.services.DealServiceInterface;
import com.wp.services.UserServiceImplementation;
import com.wp.services.UserServiceInterface;

@Controller
public class UserController {

	@Autowired
	private UserServiceInterface service;
	@Autowired
	private DealServiceInterface ddao;

	@RequestMapping("insert")
	public ModelAndView insertUser(@ModelAttribute("Users") Users user) {
		ModelAndView mv = new ModelAndView("insertUser");
		return mv;

	}

	@RequestMapping("insertuser1")
	public ModelAndView enterUser(@ModelAttribute("Users") Users user) {

		service.addUser(user);
		ModelAndView mv = new ModelAndView("viewuser");
		return mv;
	}
	@RequestMapping("updateuser")
	public ModelAndView updateUser(@SessionAttribute("email") String email) {
		Users user = service.getUser(email);
		ModelAndView mv = new ModelAndView("updateUser");
		mv.addObject("user", user);
		return mv;
	}
	@RequestMapping("update")
	public ModelAndView update(@ModelAttribute("user") Users user)
	{
		service.updateUser(user);
		ModelAndView mv= new ModelAndView("viewuser");
		return mv;
	}
	
	/*
	 * @RequestMapping("viewdeals") public ModelAndView viewdeals()
	 */
	

}
