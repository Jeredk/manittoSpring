package com.ymd.manitto.controller;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymd.manitto.service.MSGService;



@Controller
public class MSGController {

	@Autowired
	MSGService MS;
	
	@Autowired
	SqlSessionTemplate ss;
	

//	@RequestMapping(value = "/msg", method = RequestMethod.GET)
//	public String index(Locale locale, Model model) {
//
//		return "msg";
//	}

	@RequestMapping(value = "/SendMSG", method = RequestMethod.GET)
	public String msg() {

		return "SendMSG";

	}

	@RequestMapping(value = "/SendMSG", method = RequestMethod.POST)
	public String msg2(@RequestParam Map<String, Object> map) {
		ss.insert("member.msg", map);
		
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
	
	@RequestMapping(value = "/msgList2", method = RequestMethod.GET)
	@ResponseBody
	public List<Map<String, Object>> msgList2(Model model) {
		String SENDER = null;
		List<Map<String, Object>> msgList = MS.selectmsg(SENDER);
		return msgList; 
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