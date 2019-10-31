package com.ymd.manitto.service;

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

	
}
