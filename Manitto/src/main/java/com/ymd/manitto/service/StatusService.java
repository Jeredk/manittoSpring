package com.ymd.manitto.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymd.manitto.dao.SampleDAO;
import com.ymd.manitto.dao.StatusDAO;

@Service
public class StatusService {
	
	@Autowired
	StatusDAO statusDao;
	
	public Map<String, Object> statusSelect(Map<String, Object> map){
		return statusDao.statusSelect(map);
	}
	
	public int statusUpdate(Map<String, Object> map) {
		return statusDao.statusUpdate(map);
	}
	


}
