package com.ymd.manitto.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymd.manitto.dao.MyPageDAO;

@Service
public class MyPageService {
	@Autowired
	MyPageDAO myPageDao;
	
	public void updatemyinfo(Map<String, Object> map) {
		myPageDao.updatemyinfo(map);
	}
	
	

}
