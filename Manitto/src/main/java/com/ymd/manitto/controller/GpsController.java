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
import com.ymd.manitto.service.likeService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class GpsController {

	@Autowired
	likeService likeser;
	
	@Autowired
	StringUtils utils;
	
	List<Gps> gpsList = new ArrayList<Gps>();
	private static final Logger logger = LoggerFactory.getLogger(GpsController.class);
	@RequestMapping(value = "/realTimeGps", method = RequestMethod.POST)
	@ResponseBody
	public Gps getGps(@RequestBody Gps gps) {
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
		GpsService gpsSer = new GpsService();
		String id = String.valueOf(map.get("id"));
		System.out.println(id);
		
		Gps gps = new Gps();
		gps.setId(id);
		for (int i = 0; i < gpsList.size(); i++) {
			Gps g = gpsList.get(i);
		if (id.equals(g.getId())) {
			gps.setLat(gpsList.get(i).getLat());
			gps.setLng(gpsList.get(i).getLng());				
		}
		}
		
		logger.debug(gps.toString());
		
		List<User> userIn5km = new ArrayList<User>();
		for (int i = 0; i < gpsList.size(); i++) {
			Gps g = gpsList.get(i);
			if (id.equals(g.getId())) {
							
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
	
	@RequestMapping(value = "/totalCount", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> totalCount(@RequestBody Map<String, Object> map){
		String id = String.valueOf(map.get("id"));
		int count = likeser.LikeMeCount(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("count",count);
		System.out.println("==================");
		System.out.println("나를 좋아하는 사람"+count);
		System.out.println("==================");
		List<String>list=likeser.LikeMeCountIn5km(id);
		GpsService gpsSer = new GpsService();
		int in5kmCount = 0;
		Gps gps1 = new Gps();
		for (int i = 0; i < gpsList.size(); i++) {
			if (gpsList.get(i).getId().equals(id)) {				
				gps1.setId(id);
				gps1.setLat(gpsList.get(i).getLat());
				gps1.setLng(gpsList.get(i).getLng());
			}
			for (int j = 0; j < list.size(); j++) {
				String likeUser = list.get(j);
				if(gpsList.get(i).getId().equals(likeUser)) {
					Gps gps2 = gpsList.get(i);
					System.out.println("++++++++++++++");
					System.out.println(gps1.getId()); 
					System.out.println(gps2.getId()); 
					System.out.println("++++++++++++++");
					if (gps1.getId().equals(gps2.getId())) {
						if (gpsSer.in5km(gps1, gps2)) {
							in5kmCount++;
						}
					}
					
					
				}
			}
			
		}
		
		result.put("in5km",in5kmCount);
		System.out.println("==================");
		System.out.println("in5km"+count);
		System.out.println("==================");
		
		return result;
	}
	
	
	
	

}
