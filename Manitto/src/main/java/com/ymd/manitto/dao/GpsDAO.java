package com.ymd.manitto.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class GpsDAO {

		@Autowired
		SqlSessionTemplate ss;
		
		public void gpsInsert(Map<String, Object> map) {
			 ss.insert("GpsMapper.gpsInsert",map);
		}
		
		public Map<String, Object> gpsDup(String id) {
			return ss.selectOne("GpsMapper.gpsDup", id);
		}
		
		public void gpsUpdate(Map<String, Object> map) {
			 ss.update("GpsMapper.gpsUpdate", map);
		}
		
		public List<Map<String, Object>> onlineUser() {
			return ss.selectList("GpsMapper.onLineUser");
		}
		
		
	}

