package com.ymd.manitto.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymd.manitto.dao.SampleDAO;

@Service
public class SmapleService {
	
	@Autowired
	SampleDAO dao;
	
	public int join(Map<String, Object> map) {
		return dao.join(map);
	}
	
	public int sel() {
		return dao.select();
	}

}
