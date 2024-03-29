package com.ymd.manitto.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ymd.manitto.Gps;
import com.ymd.manitto.dao.GpsDAO;

@Service
public class GpsService {
	
	@Autowired
	GpsDAO dao;
	
	public boolean in5km(Gps gps1,Gps gps2) {
		double lat1 = gps1.getLat();
		double lng1 = gps1.getLng();
		double lat2 = gps2.getLat();
		double lng2 =gps2.getLng();
		double theta=0.0;
		if(lng1>lng2) {
			theta = lng1 - lng2;
		}else {
			theta = lng2 - lng1;
		}
		
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;        
        dist = dist * 1609.344; // 미터라 이렇게
        dist = Math.round(dist);
        System.out.println("dist = "+dist);
        
        if(dist <= 5000.0) {
        	return true;
        }else {
        	return false;		
		}

	}
	
	 // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }
     
    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
    
    public void gpsInsert(Map<String, Object> map) {
    	 dao.gpsInsert(map);
	}
    public Map<String, Object> gpsDup(String id) {
   	return dao.gpsDup(id);
	}

    public void gpsUpdate(Map<String, Object> map) {
   	 dao.gpsUpdate(map);
	}
    
    public List<Map<String, Object>> onlineUser() {
       	return dao.onlineUser();
    	}
    public void deleteUser(Map<String, Object> map) {
      	 dao.deleteUser(map);
   	}



}
