package com.ymd.manitto.controller;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
import com.ymd.manitto.service.likeService;
import com.ymd.manitto.utils.StringUtils;

@Controller
public class likeController {

	@Autowired
	likeService likeser;
	
	@Autowired
	StringUtils utils;
	
	@Autowired
	FcmService fcmser;
	

	private static final Logger logger = LoggerFactory.getLogger(likeController.class);
	
	@RequestMapping(value = "/likeyou", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> likeYou(@RequestBody Map<String, Object> map) throws JSONException, UnsupportedEncodingException{
		logger.debug(String.valueOf(map.get("TARGET")));
		logger.debug(String.valueOf(map.get("STALKER")));
		
		Map<String, Object> fcm = new HashMap<String, Object>();
		fcm.put("id", map.get("TARGET"));
		String targetFcm = String.valueOf(fcmser.selectFcm(fcm).get("FCM"));
		
		JSONObject reqData = new JSONObject();
		reqData.put("priority", "high");
		JSONObject contents = new JSONObject();
		contents.put("contents", URLEncoder.encode("누군가 당신을 좋아합니다", "utf-8"));
		reqData.put("data", contents);
		JSONArray ids = new JSONArray();
		ids.put(targetFcm);
		reqData.put("registration_ids", ids);

		StringBuffer resultB = new StringBuffer();
		try {
			URL url = new URL("https://fcm.googleapis.com/fcm/send");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.addRequestProperty("content-type", "application/json");
			con.addRequestProperty("Authorization", "key=AAAAu2OqvsA:APA91bHUjnsBmjyxUYhtlWtxC4uE-YAiULhWB2lBxxFLB6mDlFwrPCHpjNqFN3RZYMI8g7Yc8Y8iOvF0XdwDGZYtu51ik1qe2D_ortyD1nsXlhh3idT4tbuvhokB3NPR-gSmhkQ8NDUt");
			DataOutputStream out = new DataOutputStream(con.getOutputStream());
			String param = reqData.toString();
			out.writeBytes(param);
			out.flush();

			InputStream is = con.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader reader = new BufferedReader(isr);
			String separator = "";

			while (true) {
				String data = reader.readLine();
				if (data == null) {
					break;
				}
				resultB.append(separator + data);
				separator = "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
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
			String targetId=(String) list.get(i).get("TARGET");
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
	
	@RequestMapping(value="/addBan", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addBan(@RequestBody Map<String, Object> map){
				
		likeser.addBan(map);
		
		return map;
	}
	
	@RequestMapping(value="/banList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, List<String>> banList(@RequestBody Map<String, Object> map){
				
		String id = String.valueOf(map.get("id"));
		List<String> list = likeser.banList(id);
		
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		
		result.put("result", list);
		
		return result;
	}
	
	
	
	

}
