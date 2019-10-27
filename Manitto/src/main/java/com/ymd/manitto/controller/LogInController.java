package com.ymd.manitto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ymd.manitto.HomeController;



@Controller
public class LogInController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/logIn", method = RequestMethod.GET)
	public String home(HttpServletRequest req,HttpSession httpSession) {

		return "logIn_View";
	}
}
