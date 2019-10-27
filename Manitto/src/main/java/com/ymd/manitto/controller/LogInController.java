package com.ymd.manitto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ymd.manitto.HomeController;



@Controller
public class LogInController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/logIn", method = RequestMethod.GET)
	public ModelAndView firstPage(HttpServletRequest req,HttpSession httpSession,ModelAndView mav) {
		
		mav.setViewName("logIn_View");

		return mav;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUpPage(HttpServletRequest req,HttpSession httpSession,ModelAndView mav) {
		
		mav.setViewName("signUp_View");
		
		return mav;
	}
}


