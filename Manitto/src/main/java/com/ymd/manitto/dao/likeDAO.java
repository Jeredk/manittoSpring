package com.ymd.manitto.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class likeDAO {
		
		@Autowired
		SqlSessionTemplate ss;
		
		public int likeyou(Map<String, Object> map) {
			return ss.insert("UserMapper.likeyou", map);
		}
		
		
		
	}

