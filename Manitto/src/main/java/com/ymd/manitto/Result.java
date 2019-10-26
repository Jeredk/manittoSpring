package com.ymd.manitto;

public class Result {
	private String result;

	public Result(String name) {
		this.result=name;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Result [result=" + result + "]";
	}

	

}
