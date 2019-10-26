package com.ymd.manitto.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


	@Repository
	public class SampleDAO {
		
		@Autowired
		SqlSessionTemplate a;
		
		public int join(Map<String, Object> map) {
			return a.insert("member.join", map);
		}
		
		public int select() {
			return a.selectOne("member.sel");
		}
		
		
	}

