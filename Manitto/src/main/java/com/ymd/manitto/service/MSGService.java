package com.ymd.manitto.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ymd.manitto.dao.MSGDao;

@Service
public class MSGService {
	
	@Autowired 
	MSGDao dao;
	

	 public void msg(Map<String, Object>map) {
			dao.msgInsert(map);
		}
	 
	 public List<Map<String, Object>> selectmsg(String SENDER) {
		return dao.sendmsgList(SENDER);
		
	}
	 public List<Map<String, Object>> selectmsg2(String RECEIVER) {
			return dao.receivemsgList(RECEIVER);
			
		}
	 
	 public void msgDelete(Map<String,Object> map) {
		 dao.msgDelete(map);
	 }
	 
	 public void msgCheck(String id) {
			dao.msgCheck(id);
		}
	 
	 public int newmsgCount(String id) {
			
			int count = dao.newmsgCount(id);
			return count;
		}
	 
	 public boolean messageLimit(Map<String, Object> map) {
		 return dao.messageLimit(map);
		 
	 }
	 
	 public void deleteReceiveMsg(int number) {
		 dao.deleteReceiveMsg(number);
	 }
	 
	 public void deleteSendMsg(int number) {
		 dao.deleteSendMsg(number);
	 }
	 
	
//	 public int checkCount(String id) {
//			return dao.checkCount(id);
//		}
//	
}
