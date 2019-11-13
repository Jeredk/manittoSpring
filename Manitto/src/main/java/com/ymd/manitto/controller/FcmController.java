package com.ymd.manitto.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.ymd.manitto.User;
import com.ymd.manitto.service.FcmService;
import com.ymd.manitto.service.GpsService;
import com.ymd.manitto.service.MSGService;
import com.ymd.manitto.service.likeService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class FcmController {

	@Autowired
	StringUtils utils;
	@Autowired
	FcmService ser;
	@Autowired
	MSGService msgser;
	

	private static final Logger logger = LoggerFactory.getLogger(FcmController.class);
	
	@RequestMapping(value = "/fcm", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> fcm(@RequestBody Map<String, Object> map){
		System.out.println("@@@@@");
		logger.debug(map.toString());
		
		
			ser.updateFcm(map);
			int msgCount=msgser.newmsgCount(String.valueOf(map.get("id")));
			map.put("msgCount",msgCount);
		
		
		return map;
	}
	

}
