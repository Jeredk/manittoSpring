package com.ymd.manitto.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymd.manitto.dao.LogInDAO;

@Service
public class LogInService {

	@Autowired
	LogInDAO logInDao;

	public Map<String, Object> selectUser(Map<String, Object> map) {
		return logInDao.selectUser(map);

	}

	public int signUpUser(Map<String, Object> map) {
		return logInDao.signUpUser(map);
	}

}
