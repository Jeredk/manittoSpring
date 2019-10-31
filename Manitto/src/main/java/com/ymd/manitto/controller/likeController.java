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

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ymd.manitto.service.likeService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class likeController {

	@Autowired
	likeService likeser;
	
	@Autowired
	StringUtils utils;
	

	private static final Logger logger = LoggerFactory.getLogger(likeController.class);
	
	@RequestMapping(value = "/likeyou", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> likeYou(@RequestBody Map<String, Object> map){
		logger.debug(String.valueOf(map.get("TARGET")));
		logger.debug(String.valueOf(map.get("STALKER")));
		int result = 0;
		try {
			result = likeser.likeyou(map);			
		}catch (MySQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			result = 2;
		}
		map.put("result", result);
		
		return map;
	}
	
	
	

}
