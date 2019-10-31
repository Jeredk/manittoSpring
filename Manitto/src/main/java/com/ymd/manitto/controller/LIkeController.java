package com.ymd.manitto.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymd.manitto.Gps;
import com.ymd.manitto.HomeController;
import com.ymd.manitto.User;
import com.ymd.manitto.service.GpsService;
import com.ymd.manitto.service.likeService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class LIkeController {

	@Autowired
	likeService likeser;
	
	@Autowired
	StringUtils utils;
	

	private static final Logger logger = LoggerFactory.getLogger(LIkeController.class);
	
	@RequestMapping(value = "/likeYou", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> likeYou(@RequestBody Map<String, Object> map){
		logger.debug(String.valueOf(map.get("TARGET")));
		logger.debug(String.valueOf(map.get("STALKER")));
		int result = likeser.likeyou(map);
		map.put("result", result);
		
		return map;
	}
	
	
	

}
