package com.ymd.manitto.service;

import org.springframework.stereotype.Service;

import com.ymd.manitto.Gps;

@Service
public class GpsService {
	
	public boolean in5km(Gps gps1,Gps gps2) {
		double lat1 = gps1.getLat();
		double lng1 = gps1.getLng();
		double lat2 = gps2.getLat();
		double lng2 =gps2.getLng();
		
		double theta = lng1 - lng2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;        
        dist = dist * 1609.344; // 미터라 이렇게
        dist = Math.round(dist);
        System.out.println("dist = "+dist);
        
        if(dist <= 5000) {
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


}
