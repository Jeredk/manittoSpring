package com.ymd.manitto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.ymd.manitto.service.MSGService;
import com.ymd.manitto.service.likeService;



@Controller
public class MSGController {

	@Autowired
	MSGService MS;
	
	@Autowired
	SqlSessionTemplate ss;
	
	@Autowired
	com.ymd.manitto.utils.StringUtils util;
	
	@Autowired
	likeService likeSer;
	

//	@RequestMapping(value = "/msg", method = RequestMethod.GET)
//	public String index(Locale locale, Model model) {
//
//		return "msg";
//	}
	private static final Logger logger = LoggerFactory.getLogger(MSGController.class);
	@RequestMapping(value = "/SendMSG", method = RequestMethod.GET)
	public String msg() {

		return "SendMSG";

	}
	
	@RequestMapping(value = "/SendMessage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> message(@RequestBody Map<String, Object> map){
		logger.debug("------------SendMessage------------");
		logger.debug(map+"");
		logger.debug("------------SendMessage------------");
		MS.msg(map);
		
		
		return map;
	}

	@RequestMapping(value = "/SendMSG", method = RequestMethod.POST)
	public String msg2(@RequestParam Map<String, Object> map) {
		ss.insert("message.msgInsert", map);
		
//		ss.selectList("message.msgList", SENDER);
		
		return "SendMSG_Complete";

	}
	

	
	@RequestMapping(value = "/msgList", method = RequestMethod.GET)
	public String msgList(Model model) {
		String SENDER = null;
		List<Map<String, Object>> msgList = MS.selectmsg(SENDER);
		model.addAttribute("msgList",msgList);
		
		return "msgList";
	}
	
	@RequestMapping(value = "/msgList2", method = RequestMethod.POST) // 
	@ResponseBody
	public Map<String, List<Map<String, Object>>> msgList2(
			@RequestBody Map<String, Object> map) {
		System.out.println(map);	
		String SENDER = (Integer) map.get("id") + "";
		
		MS.msgCheck(SENDER);
		
		List<Map<String, Object>> msgList = MS.selectmsg(SENDER);
		for (int i = 0; i < msgList.size(); i++) {
			String rec = String.valueOf(msgList.get(i).get("RECEIVER"));
			String name = util.userSelectByKakao(rec).getNAME();
			System.out.println(name+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			msgList.get(i).put("NAME",name);
		}
		Map<String, List<Map<String, Object>>> returnMap = new HashMap<String, List<Map<String, Object>>>();
		returnMap.put("list", msgList);
		return returnMap; 
	}
	
	@RequestMapping(value = "/msgList3", method = RequestMethod.POST) //
	@ResponseBody
	public Map<String, List<Map<String, Object>>> msgList3(
			@RequestBody Map<String, Object> map) {
		System.out.println(map);
		
		String RECEIVER = (Integer) map.get("id") + "";
		
		MS.msgCheck(RECEIVER);
		List<Map<String, Object>> msgList = MS.selectmsg2(RECEIVER);
		logger.warn("msgList " + msgList.size());
		for (int i = 0; i < msgList.size(); i++) {
			String rec = String.valueOf(msgList.get(i).get("RECEIVER"));
			String name = util.userSelectByKakao(rec).getNAME();
			System.out.println(name+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			msgList.get(i).put("NAME","");
		}
		
		List<String> banList = likeSer.banList(RECEIVER);
		
		for (int i = msgList.size() - 1; i >= 0; i--) {
			logger.warn("msgList get sender " + i + " - " + msgList.get(i).get("SENDER"));
			String sender = (String)msgList.get(i).get("SENDER");
			for (int j = 0; j < banList.size(); j++) {
				logger.warn("banList get " + i + " - " + banList.get(j));
				if (banList.get(j).equals(sender)) {
					logger.warn("________________________________________");
					logger.warn(banList.get(j));
					logger.warn(sender);
					logger.warn("________________________________________");
					msgList.remove(i);
				}
			}
			
		}
		
		Map<String, List<Map<String, Object>>> returnMap = new HashMap<String, List<Map<String, Object>>>();
		returnMap.put("list", msgList);
		return returnMap; 
	}
	
	@RequestMapping(value = "/msgDelete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> msgDelete(
			@RequestBody Map<String, Object> map) {
		System.out.println(map);
		MS.msgDelete(map);
		
		return map; 
	}
	
	@RequestMapping(value = "/messageLimit", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> messageLimit( 	 // JSON 으로 보내려고
			@RequestBody Map<String, Object> map) {	// JSON 으로 받으려고

		
		Map<String, Object> result = new HashMap<String, Object>();
		logger.debug("+++++++++++"+MS.messageLimit(map)+"++++++++++");
		result.put("result", MS.messageLimit(map));
		return result; 
	}
	
	@RequestMapping(value = "/dReceiveMsg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteReceiveMsg( 	 // JSON 으로 보내려고
			@RequestBody Map<String, Object> map) {	// JSON 으로 받으려고
		MS.deleteReceiveMsg((Integer)map.get("NUMBER"));
		return map; 
	}
	
	@RequestMapping(value = "/deleteSendMsg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteSendMsg( 	 // JSON 으로 보내려고
			@RequestBody Map<String, Object> map) {	// JSON 으로 받으려고
		MS.deleteSendMsg((Integer)map.get("NUMBER"));
		return map; 
	}
	

//	@RequestMapping(value = "/msgList", method = RequestMethod.GET)
//	public String msgSend(Model model, HttpSession session) {
//		String id = (String) session.getAttribute("id");
//		List<Map<String, Object>> msgList = MS.selectMsg(id);
//		model.addAttribute("msgList", msgList);
//		MS.checkMsg(id);
//
//		return "MSGList";
//
//	}
//
//	@RequestMapping(value = "/msgCount", method = RequestMethod.GET)
//	@ResponseBody
//	public String msgCount(Model model, HttpServletRequest req, HttpSession session) {
//		String id = (String) session.getAttribute("id");
//		int count = ss.checkCount(id);
//
//		return count + "";
//
//	}

}