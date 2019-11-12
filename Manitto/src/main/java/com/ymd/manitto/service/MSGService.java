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
			dao.msg(map);
		}
	 
	 public List<Map<String, Object>> selectmsg(String SENDER) {
		return dao.selectmsg(SENDER);
		
	}
	 
	 public int msgDelete(int NUMBER) {
		 return dao.msgDelete(NUMBER);
	 }
//	 public int checkCount(String id) {
//			return dao.checkCount(id);
//		}
//	
}
