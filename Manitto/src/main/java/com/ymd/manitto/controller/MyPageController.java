package com.ymd.manitto.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymd.manitto.service.MyPageService;
import com.ymd.manitto.service.likeService;


@Controller
public class MyPageController {
	
	@Autowired
	likeService likeser;
	
	@Autowired
	MyPageService myPageService;
	
	private static final Logger logger = LoggerFactory.getLogger(likeController.class);
	
	@RequestMapping(value="checkmyinfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkmyinfo(@RequestBody Map<String, Object> map){
		
		logger.debug(map+"");
		logger.debug("-------------------------checkmyinfo----------------------------");
		logger.debug(map+"");
		logger.debug("-------------------------checkmyinfo----------------------------");
		Map<String,Object> apersoninfo = likeser.findafriend(map);
		logger.debug(apersoninfo+"");

		return apersoninfo;	
	}
	
	@RequestMapping(value="renewinfo", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> renewmyinfo(@RequestBody Map<String, Object> map){
		logger.debug("-------------------------renewmyinfo----------------------------");
		logger.debug(map+"");
		logger.debug("-------------------------renewmyinfo----------------------------");
		myPageService.updatemyinfo(map);
		
		return map;
		
	}
	
	@RequestMapping(value = "/deleteAccount", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteAccount( 	 // JSON 으로 보내려고
			@RequestBody Map<String, Object> map) {	// JSON 으로 받으려고
		logger.debug("-------------------------deleteAccount----------------------------");
		logger.debug(map+"");
		logger.debug("-------------------------deleteAccount----------------------------");
		myPageService.deleteAccount(map);
		return map;
	}
	
	
	
}
