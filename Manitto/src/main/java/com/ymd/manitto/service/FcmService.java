package com.ymd.manitto.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymd.manitto.Gps;
import com.ymd.manitto.dao.FcmDAO;
import com.ymd.manitto.dao.GpsDAO;

@Service
public class FcmService {
	
	@Autowired
	FcmDAO dao;
	
	
	public void updateFcm(Map<String, Object>map) {
		dao.fcmUpdate(map);
	}
	
	public Map<String, Object> selectFcm(Map<String, Object> map) {
		return dao.selectFcm(map);
	}



}
