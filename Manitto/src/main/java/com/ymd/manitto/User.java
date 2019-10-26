package com.ymd.manitto;

public class User {
	private String name;
	private String tel;
	private int gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", tel=" + tel + ", gender=" + gender + "]";
	}
}
