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
	
	public void msgDelete(Map<String,Object> map) {
		ss.delete("message.msgDelete", map);
	}

	
//	public void checkMsg(String id) {
//		ss.update("member.msgCheck",id);
//	}?
//	public int checkCount(String id) {
//		return ss.selectOne("member.msgCount",id);
//	}
//	
}
