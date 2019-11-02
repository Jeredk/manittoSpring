package com.ymd.manitto.dao;

import java.util.List;
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
		
		public List<Map<String, Object>> loveSight(String id){
			return ss.selectList("UserMapper.loveSight", id);
		}
		
		public List<Map<String,Object>> findMyFriends(Map<String,Object> map){
			return ss.selectList("UserMapper.findMyFriends", map);
		}
		
		
	}

