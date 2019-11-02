package com.ymd.manitto;

import java.awt.PageAttributes.MediaType;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ymd.manitto.service.SmapleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	SmapleService ses;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/joinTest", method = {RequestMethod.GET,RequestMethod.POST}
	)
	public @ResponseBody Result home (@RequestBody User user, HttpSession session) {
		logger.debug("++++++++++++++++++++++++++++++++++++++++++++++");
		logger.debug(user.toString());
		Map<String, Object> map = new HashMap<String, Object>();
		session.setAttribute("name", "aa");
	;
		ses.join(map);
		
		
//		Map<String, String> aa = req.getParameter("");
//		aa.get("userId");
//		System.out.println(aa.get("userId"));
//		String id = req.getParameter("userId");
//		String pw = req.getParameter("userPw");
//		String name = req.getParameter("userName");
//		
//		System.out.println(id+" "+pw+" "+name);
		
//		return "kskim" ;
		int a = ses.sel();
		
		return new Result(String.valueOf(a));
	}

	
//	@RequestMapping(value = "/joinTest", method = {RequestMethod.GET,RequestMethod.POST})
//	@ResponseBody
//	public String home(Locale locale, Model model, HttpServletRequest req, @RequestParam("aa") JSON, HttpServletResponse res) {
//		String requestString= StringUtils.join(map);
//		logger.debug(requestString);
//		
//		
////		ses.join(map);
//		
//		
////		Map<String, String> aa = req.getParameter("");
////		aa.get("userId");
////		System.out.println(aa.get("userId"));
////		String id = req.getParameter("userId");
////		String pw = req.getParameter("userPw");
////		String name = req.getParameter("userName");
////		
////		System.out.println(id+" "+pw+" "+name);
//		
//		return "kskim" ;
//	}
	
	@RequestMapping(value = "/joinTest1", method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseEntity<String> home1(Locale locale, Model model, HttpServletRequest req, @RequestParam Map<String, Object> map, HttpServletResponse res) {
		
	return new ResponseEntity<String>("test",HttpStatus.OK);
		
	}
}
