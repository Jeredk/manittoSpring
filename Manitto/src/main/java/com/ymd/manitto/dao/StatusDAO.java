package com.ymd.manitto.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class StatusDAO {

		@Autowired
		SqlSessionTemplate ss;
		
		public Map<String,Object> statusSelect(Map<String, Object> map) {
			return ss.selectOne("StatusMapper.statusSelect",map);
		}
		
		public int statusUpdate(Map<String, Object> map) {
			return ss.update("StatusMapper.statusUpdate", map);
		}
		
		
	}

