package com.ymd.manitto.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.ymd.manitto.service.MSGService;



@Controller
public class MSGController {

	@Autowired
	MSGService MS;

//	@RequestMapping(value = "/msg", method = RequestMethod.GET)
//	public String index(Locale locale, Model model) {
//
//		return "msg";
//	}

	@RequestMapping(value = "/SendMSG", method = RequestMethod.GET)
	public String msg(Model model, HttpServletRequest req, @RequestParam Map<String, Object> map) {
		
		
		
		
		
		
//		String C =(String) map.get("C");
//		String R =(String) map.get("R");
//		String S =(String) map.get("S");
		 
	        
		MS.msg(map);
		
		return "SendMSG";

	}

	@RequestMapping(value = "/SendMSG", method = RequestMethod.POST)
	public String msgSend(Model model, HttpServletRequest req, @RequestParam Map<String, Object> map) {
		MS.msg(map);

		return "home";

	}

	@RequestMapping(value = "/msgList", method = RequestMethod.GET)
	public String msgSend(Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");
		List<Map<String, Object>> msgList = MS.selectMsg(id);
		model.addAttribute("msgList", msgList);
		MS.checkMsg(id);

		return "MSGList";

	}
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
