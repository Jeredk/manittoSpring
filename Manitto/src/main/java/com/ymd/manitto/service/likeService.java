package com.ymd.manitto.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.ymd.manitto.dao.likeDAO;

@Service
public class likeService {

	@Autowired
	likeDAO likeD;

	public int likeyou(Map<String, Object> map) throws MySQLIntegrityConstraintViolationException {
		int result = 0;
		result = likeD.likeyou(map);
		return result;

	}
	
	
	public List<Map<String, Object>> loveSight(String id){
		return likeD.loveSight(id);
	}
	
	public List<Map<String,Object>> findMyFriends(Map<String,Object> map){
		return likeD.findMyFriends(map);
	}
	
	public void loveCancelling(Map<String, Object> map) {
		likeD.loveCancelling(map);
	}

	
}
