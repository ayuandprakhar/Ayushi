package com.wp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Transporter;
import com.wp.entities.Users;
import com.wp.services.TransporterServiceInterface;
import com.wp.services.UserServiceInterface;

@Controller
@SessionAttributes(names = { "email", "username" })
public class login {
	@Autowired
	private UserServiceInterface service;
	@Autowired
	private TransporterServiceInterface service1;

	@RequestMapping("verify")
	public ModelAndView verifyUser(@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("login") String rtype) {

		if (rtype.equals("admin")) {
			if (email.equals("admin") && password.equals("admin")) {
				ModelAndView mv = new ModelAndView("adminHome");
				mv.addObject("email", email);
				return mv;

			} else {
				ModelAndView mv = new ModelAndView("invaliduser");
				return mv;
			}

		} else if (rtype.equals("user")) {
			Users u = new Users();
			u.setU_emailid(email);
			u.setU_password(password);
			Users user = service.verifyUser(u);
			if (user != null) {
				ModelAndView mv = new ModelAndView("userHome");
				mv.addObject("email", email);
				mv.addObject("username", user.getU_name());
				return mv;
			} else {
				ModelAndView mv = new ModelAndView("invaliduser");
				return mv;
			}
		} else {
			Transporter t = new Transporter();
			t.setT_email_id(email);
			t.setT_password(password);
			Transporter trans = service1.verifyTransporter(t);
			if (trans != null) {
				if (trans.isVerify()) {
					ModelAndView mv = new ModelAndView("transporterHome");
					mv.addObject("email", email);
					mv.addObject("username", trans.getT_firm_name());
					return mv;
				} else {
					ModelAndView mv = new ModelAndView("invaliduser");
					return mv;

				}

			} else {
				ModelAndView mv = new ModelAndView("invaliduser");
				return mv;
			}

		}

	}

}
