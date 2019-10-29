package com.ymd.manitto;

public class Gps {
	private double lat;
	private double lng;
	private String id;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Gps [lat=" + lat + ", lng=" + lng + ", id=" + id + "]";
	}
	
	
}
