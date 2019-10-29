package com.ymd.manitto.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogInDAO {
	@Autowired
	SqlSessionTemplate ss;
	
	public Map<String, Object> selectUser(Map<String, Object> map) {
		return ss.selectOne("logInMapper.selectUser",map);	
	}
	
	public int signUpUser(Map<String,Object> map){
		return ss.insert("logInMapper.signUp", map);
	}

}
