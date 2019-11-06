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
import com.ymd.manitto.service.GpsService;
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
	
	
	
	@RequestMapping(value = "/lovesight", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> loveSight(@RequestBody Map<String, Object> map){
		String id = String.valueOf(map.get("id"));
		List<Map<String, Object>> list = likeser.loveSight(id);
		List<User> userList = new ArrayList<User>();
		Map<String, Object> json = new HashMap<String, Object>();
		for (int i = 0; i < list.size(); i++) {
			String targetId=(String) list.get(i).get("target");
			User user = utils.userSelectByKakao(targetId);
			
			userList.add(user);	
			logger.debug("-------------------------loveSight----------------------------");
			logger.debug(user.getNAME());
			logger.debug("-------------------------loveSight----------------------------");
		}
		json.put("loveList",userList);
		
		return json;
	}

	@RequestMapping(value="/lovecancel", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> loveCancelling(@RequestBody Map<String, Object> map){
		logger.debug("-------------------------lovecancelling----------------------------");
		logger.debug(map+"");
		//logger.debug(String.valueOf(map.get("STALKER")));
		logger.debug("-------------------------lovecancelling----------------------------");
		likeser.loveCancelling(map);
		return map;
	}

	
	@RequestMapping(value="/afriend", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findafriend(@RequestBody Map<String, Object> map){
		logger.debug("-------------------------selectafriend----------------------------");
		logger.debug(map+"");
		logger.debug("-------------------------selectafriend----------------------------");
		Map<String,Object> apersoninfo = likeser.findafriend(map);
		logger.debug(apersoninfo+"");
//		Map<String, Object> json = new HashMap<String, Object>();
//		json.put("findafriend",apersoninfo);
		return apersoninfo;
	}
	
	
	
//	@RequestMapping(value="/findMyFriends",method = RequestMethod.POST)
//	@ResponseBody
//	public Map<String, Object> findMyFriends(@RequestBody Map<String,Object> map){
//		List<Map<String,Object>> list = likeser.findMyFriends(map);
//		return map;
//		
//	}
//	
	

}
