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
	
	
	public void msg(Map<String, Object> map) {
		ss.insert("message.msg",map);
	}
		
	public List<Map<String,Object>> selectmsg(String SENDER){
		return ss.selectList("message.msgList", SENDER);
	}
	
//	public List<Map<String,Object>> selectmsg(Map<String, Object>map){
//		return ss.selectList("message.msgList", map);
//	}
	

	
//	public void checkMsg(String id) {
//		ss.update("member.msgCheck",id);
//	}?
//	public int checkCount(String id) {
//		return ss.selectOne("member.msgCount",id);
//	}
//	
}
