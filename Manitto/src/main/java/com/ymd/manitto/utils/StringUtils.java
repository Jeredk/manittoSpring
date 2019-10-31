package com.ymd.manitto.utils;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ymd.manitto.User;

@Repository
public class StringUtils {
	@Autowired
	SqlSessionTemplate ss;
	
	public User userSelectByKakao(String id) {	
		User user = ss.selectOne("UserMapper.userSelectByKakao", id);
		return user;
		
	}
	
}
