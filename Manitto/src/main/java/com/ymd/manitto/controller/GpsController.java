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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymd.manitto.Gps;
import com.ymd.manitto.HomeController;
import com.ymd.manitto.User;
import com.ymd.manitto.service.GpsService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class GpsController {
	@Autowired
	GpsService gpsSer;
	@Autowired
	StringUtils utils;
	
	List<Gps> gpsList = new ArrayList<Gps>();
	private static final Logger logger = LoggerFactory.getLogger(GpsController.class);
	@RequestMapping(value = "/realTimeGps", method = RequestMethod.POST)
	@ResponseBody
	public Gps getGps(
			@RequestBody Gps gps) {
				System.out.println(gps.getId());
				System.out.println(gps.getLat());
				System.out.println(gps.getLng());
				boolean isDup = false;
				for (int i = 0; i < gpsList.size(); i++) {
					Gps g = gpsList.get(i);
					if(g.getId().equals(gps.getId())) {
						isDup = true;
						g.setLat(gps.getLat());
						g.setLng(gps.getLng());
					}
				}
				if(isDup) {
					
				} 
				else {
					gpsList.add(gps);					
				}
				
				System.out.println("총 접속자 = "+gpsList.size());
				
				return gps;
	}
	
	
	@RequestMapping(value = "/nearUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> nearUser(@RequestBody Map<String, Object> map, Locale locale, Model model) {
		String id = String.valueOf(map.get("id"));
		System.out.println(id);
		
		Gps gps = new Gps();
		gps.setId(id);
		
		List<User> userIn5km = new ArrayList<User>();
		for (int i = 0; i < gpsList.size(); i++) {
			Gps g = gpsList.get(i);
			if (id.equals(g.getId())) {
				gps.setLat(gpsList.get(i).getLat());
				gps.setLng(gpsList.get(i).getLng());				
			}else {
				boolean is5km = gpsSer.in5km(gps, g);
				System.out.println(is5km);
				if (is5km) {
					userIn5km.add(utils.userSelectByKakao(g.getId()));
				}
			}
			
			
		}
		
		
		
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("result", userIn5km);
		return returnMap;			
	}
	
	
	

}
