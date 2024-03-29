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

import com.ymd.manitto.service.StatusService;

import com.ymd.manitto.service.MSGService;

import com.ymd.manitto.service.likeService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class GpsController {

	@Autowired
	likeService likeser;

	@Autowired
	StringUtils utils;
	
	@Autowired
	MSGService msgser;
	
	@Autowired
	GpsService gpsser;
	
	@Autowired
	StatusService statusService;
	
	private static final Logger logger = LoggerFactory.getLogger(GpsController.class);

	@RequestMapping(value = "/realTimeGps", method = RequestMethod.POST)
	@ResponseBody
	public Gps getGps(@RequestBody Gps gps) {
		System.out.println(gps.getId());
		System.out.println(gps.getLat());
		System.out.println(gps.getLng());
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> gpsMap = new HashMap<String, Object>();
		gpsMap.put("kakaocode",gps.getId());
		gpsMap.put("lat",gps.getLat());
		gpsMap.put("lng",gps.getLng());
		map=gpsser.gpsDup(gps.getId());
		if (map == null) {
			gpsser.gpsInsert(gpsMap);
		}else {
			gpsser.gpsUpdate(gpsMap);
		}
		
		System.out.println("珥� �젒�냽�옄 = " + gpsser.onlineUser().size());

		return gps;
	}

	@RequestMapping(value = "/nearUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> nearUser(@RequestBody Map<String, Object> map, Locale locale, Model model) {
		
		String id = String.valueOf(map.get("id"));
		System.out.println(id);

		Gps gps = new Gps();
		gps.setId(id);
		List<Map<String, Object>> userList = gpsser.onlineUser();
		List<Gps> gpsList = new ArrayList<Gps>();
		for (int i = 0; i < gpsser.onlineUser().size(); i++) {
			Map<String, Object> user = userList.get(i);
			if (id.equals(user.get("KAKAOCODE"))) {
				gps.setLat((double) user.get("LAT"));
				gps.setLng((double) user.get("LNG"));
			}else {
				Gps gps2 = new Gps();
				gps2.setId(String.valueOf(user.get("KAKAOCODE")));
				gps2.setLat((double) user.get("LAT"));
				gps2.setLng((double) user.get("LNG"));
				gpsList.add(gps2);
			}
		}

		logger.debug(gps.toString());

		List<User> userIn5km = new ArrayList<User>();
		for (int i = 0; i < gpsList.size(); i++) {
			Gps g = gpsList.get(i);
			
				boolean is5km = gpsser.in5km(gps, g);
				System.out.println(is5km);
				if (is5km) {
					userIn5km.add(utils.userSelectByKakao(g.getId()));
				}
			}
		for (int i = userIn5km.size()-1; i >= 0 ; i--) {
			User FrUser = userIn5km.get(i);
			Map<String, Object> im = new HashMap<String, Object>();
			im.put("KAKAOCODE",id);
			List<Map<String, Object>> fr = likeser.findMyFriends(im);
			String user5km = FrUser.getKAKAOCODE();
			for (int j = 0; j < fr.size(); j++) {
				if ( user5km.equals(String.valueOf(fr.get(j).get("KAKAOCODE")))) {
				userIn5km.remove(i);
				}
				
			}
			
				
			}
		
		
				
		
		

		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("result", userIn5km);
		return returnMap;
	}

	
	@RequestMapping(value = "/totalCount", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> totalCount(@RequestBody Map<String, Object> map) {
		String id = String.valueOf(map.get("id"));

		int count = likeser.LikeMeCount(id);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("count", count);

		System.out.println("==================");
		System.out.println("�굹瑜� 醫뗭븘�븯�뒗 �궗�엺" + count);
		System.out.println("==================");

		List<String> likeMeList = likeser.LikeMeCountIn5km(id);
		List<Map<String, Object>> userList = gpsser.onlineUser();

		int in5kmCount = 0;
		Gps gps = new Gps();
		
		List<Gps> gpsList = new ArrayList<Gps>();
		for (int i = 0; i < userList.size(); i++) {
			
			Map<String, Object> user = userList.get(i);
			if (id.equals(user.get("KAKAOCODE"))) {
				gps.setLat((double) user.get("LAT"));
				gps.setLng((double) user.get("LNG"));
			}
		}
		List<Gps> likeMeGpsList = new ArrayList<Gps>();
		for (int i = 0; i < likeMeList.size(); i++) {
			Map<String, Object> lmap = gpsser.gpsDup(likeMeList.get(i));
			if(lmap != null) {
				
				Gps likeMeGps = new Gps();
				likeMeGps.setId(String.valueOf(lmap.get("STALKER")));
				likeMeGps.setLat((double)(lmap.get("LAT")));
				likeMeGps.setLng((double)(lmap.get("LNG")));
				likeMeGpsList.add(likeMeGps);
			}

		}		
		
		for (int i = 0; i < likeMeGpsList.size(); i++) {
			boolean in5km = gpsser.in5km(gps, likeMeGpsList.get(i));
			if(in5km) {
				in5kmCount++;
			}
		}
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		logger.debug("++++++++++++++++++++++++++++++++++++SelectMyStatusNumberIntoGPSController+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		logger.debug(map+"");
		Map<String, Object> stats = statusService.statusSelect(map);
		
		System.out.println("1@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("1  -" + stats.toString());
		System.out.println("11  -" + stats.get("STATUS").toString());
		System.out.println("2@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

		int stat = (int) stats.get("STATUS");
		logger.debug(stat+"This is my Status");
		logger.debug("++++++++++++++++++++++++++++++++++++SelectMyStatusNumberIntoGPSController+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		result.put("STATUS",stat);
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		

		result.put("in5km", in5kmCount);
		logger.debug("==================");
		logger.debug("in5km : " + in5kmCount);
		logger.debug("==================");
		
		int msgCount = msgser.newmsgCount(id);
		result.put("msgCount",msgCount);

		
		
		return result;
	}
	
	@RequestMapping(value = "/deleteGps", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteGps(@RequestBody Map<String, Object> map) {
		gpsser.deleteUser(map);
		
		logger.debug("�젒�냽醫낅즺 : " + map.get("id"));
		return map;
	}

}
