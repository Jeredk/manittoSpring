package com.ymd.manitto.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyPageDAO {
	
	@Autowired
	SqlSessionTemplate ss;
	
	public void updatemyinfo(Map<String, Object> map) {
		ss.update("MyPageMapper.updatemyinfo",map);
		
	}
	public void deleteAccount(Map<String, Object> map) {
		ss.delete("MyPageMapper.deleteaccount", map);
	}
}
