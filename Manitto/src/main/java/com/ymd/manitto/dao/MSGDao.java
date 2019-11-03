package com.ymd.manitto.dao;

import java.util.List;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MSGDao {
	
	@Autowired
	SqlSessionTemplate ss;
	
	
	public void msg(Map<String, Object>map ) {
		ss.insert("member.msg",map);
	}
	
	public List<Map<String, Object>> selectMsg(String id) {
		return ss.selectList("member.selectMsg",id);
	}
	public void checkMsg(String id) {
		ss.update("member.msgCheck",id);
	}
//	public int checkCount(String id) {
//		return ss.selectOne("member.msgCount",id);
//	}
//	
}
