package com.ymd.manitto.dao;

import java.util.List;
import java.util.Map;

import javax.mail.Message;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class MSGDao {
	
	@Autowired
	SqlSessionTemplate ss;
	
	
	public void msgInsert(Map<String, Object> map) {
		ss.insert("message.msgInsert",map);
	}
		
	public List<Map<String,Object>> sendmsgList(String SENDER){
		return ss.selectList("message.sendmsgList", SENDER);
	}
	
	public List<Map<String,Object>> receivemsgList(String RECEIVER){
		return ss.selectList("message.receivemsgList", RECEIVER);
	}
	
	public void msgDelete(Map<String,Object> map) {
		ss.delete("message.msgDelete", map);
	}
	
	public void msgCheck(String id) {
		ss.update("message.msgCheck", id);
	}

	public int newmsgCount(String id) {
		List<Map<String, Object>> list = ss.selectList("message.newmsgCount", id);
		int count = list.size();
		return count;
	}
	
	public boolean messageLimit(Map<String, Object> map) {
		Map<String, Object> messageLimit = ss.selectOne("message.messageLimit", map);
		if(messageLimit == null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void deleteReceiveMsg(int number) {
		ss.update("message.deleteReceiveMsg", number);
	}
	
	public void deleteSendMsg(int number) {
		ss.update("message.deleteSendMsg", number);
	}
	

	
//	public void checkMsg(String id) {
//		ss.update("member.msgCheck",id);
//	}?
//	public int checkCount(String id) {
//		return ss.selectOne("member.msgCount",id);
//	}
//	
}
