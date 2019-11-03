package com.ymd.manitto.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class MessageDAO {
		
		@Autowired
		SqlSessionTemplate a;
		
		public void msg(Map<String, Object>map) {
			a.insert("member.msg", map);
		}
		public void checkMsg(String id) {
			a.update("member.msgCheck",id);
		}
		
		
	}

