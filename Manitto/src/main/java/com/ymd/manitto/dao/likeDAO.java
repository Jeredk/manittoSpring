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

		public void loveCancelling(Map<String, Object> map) {
			ss.delete("UserMapper.noMoreManitto", map)
			;
		}
		public int likeMeCount(String id) {
			List<String> list = ss.selectList("UserMapper.totalLikeMe",id);
			int count = list.size();
			System.out.println("count = = = "+count);
			return count;
		}
		
		public List<String> likeMeCountIn5km(String id) {
			List<String> list = ss.selectList("UserMapper.totalLikeMe",id);			
			return list;
		}
		
		public Map<String, Object> findafriend(Map<String, Object> map){
			return ss.selectOne("UserMapper.selectUser", map);
		}
		
		public void addBan(Map<String, Object> map){
			 ss.insert("UserMapper.addBan", map);
		}
		
		public List<String> banList(String id){
			return ss.selectList("UserMapper.banList", id);
		}
		
		
		
	}

