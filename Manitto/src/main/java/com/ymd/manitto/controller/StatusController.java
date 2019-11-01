package com.ymd.manitto.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymd.manitto.service.StatusService;

@Controller
public class StatusController {
	
	@Autowired
	StatusService statusService;
	
	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

	@RequestMapping(value="/selectMyStatus",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> selectMyStatus(@RequestBody Map<String, Object> map){
		logger.debug("++++++++++++++++++++++++++++++++selectMyStatus++++++++++++++++++++++++++++++++");
		logger.debug(map.toString());
		logger.debug("++++++++++++++++++++++++++++++++selectMyStatus++++++++++++++++++++++++++++++++");	
		statusService.statusSelect(map);
		return map;
	}
	
	@RequestMapping(value="/updateMyStatus", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateMyStatus(@RequestBody Map<String, Object> map){
		logger.debug("++++++++++++++++++++++++++++++++updateMyStatus++++++++++++++++++++++++++++++++");
		logger.debug(map.toString());
		logger.debug("++++++++++++++++++++++++++++++++updateMyStatus++++++++++++++++++++++++++++++++");	
		statusService.statusUpdate(map);
		return map;	
	}
	
	
	
	
	
	
	
	
	
}
