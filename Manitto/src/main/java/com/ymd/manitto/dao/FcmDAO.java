package com.ymd.manitto.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class FcmDAO {

		@Autowired
		SqlSessionTemplate ss;
		
		
		public void fcmUpdate(Map<String, Object> map) {
			 ss.update("UserMapper.updateFcm",map);
		}
		
		public Map<String, Object> selectFcm(Map<String, Object> map) {
			return ss.selectOne("UserMapper.selectFcm",map);
		}
		
		
		
	}

