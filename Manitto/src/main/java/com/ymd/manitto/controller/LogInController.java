package com.ymd.manitto.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ymd.manitto.HomeController;
import com.ymd.manitto.service.LogInService;



@Controller
public class LogInController {
	
	@Autowired
	LogInService logInService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/logIn", method = RequestMethod.GET)
	public ModelAndView firstPage(HttpServletRequest req,HttpSession httpSession,ModelAndView mav) {		
		mav.setViewName("logIn_View");
		return mav;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.GET)
	public ModelAndView signUpPageGET(HttpServletRequest req,HttpSession httpSession,ModelAndView mav) {		
		mav.setViewName("signUp_View");
		return mav;
	}
	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ModelAndView signUpPagePOST(HttpServletRequest req,HttpSession httpSession,ModelAndView mav) {
		
		mav.setViewName("signUp_View");
		
		return mav;
	}
	

	@RequestMapping(value = "/signCheck", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> signUpPage2(@RequestBody Map<String, Object> map) {
		logger.debug("++++++++++++++++++++++++++++++++signCheck++++++++++++++++++++++++++++++++");
		logger.debug(map.toString());
		logger.debug("++++++++++++++++++++++++++++++++signCheck++++++++++++++++++++++++++++++++");
		Object kakaoCodeAccount = map.get("KAKAOCODE");
		logger.debug(kakaoCodeAccount.toString());
		logger.debug("++++++++++++++++++++++++++++++++signCheck++++++++++++++++++++++++++++++++");
		
		Map<String, Object> result = logInService.selectUser(map);
		if(result != null) {
			map.put("result", "login");
		} else {	
			map.put("result", "needSignUp");
		}
		return map;		
	}
	
	@RequestMapping(value="/signUpInspection", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> signUpInspection(@RequestBody Map<String, Object> map){
		logger.debug("++++++++++++++++++++++++++++++++signUpInspection++++++++++++++++++++++++++++++++");
		logger.debug(map.toString());
		logger.debug("++++++++++++++++++++++++++++++++signUpInspection++++++++++++++++++++++++++++++++");
		
		
		logInService.signUpUser(map);
		
		
		return map;
		
	}
}


