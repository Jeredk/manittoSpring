package com.ymd.manitto.controller;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ymd.manitto.Gps;

@Controller
public class GpsController {

	@RequestMapping(value = "/realTimeGps", method = RequestMethod.POST)
	public void getGps(
			@RequestBody Gps gps) {
				System.out.println(gps.getId());
				System.out.println(gps.getLat());
				System.out.println(gps.getLng());
	}
	
	

}
