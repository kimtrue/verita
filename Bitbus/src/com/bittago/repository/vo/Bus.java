package com.bittago.repository.vo;

public class Bus {

	private int busNo; 			// 버스 고유번호
	private String busLicense; 	// 버스 차량번호
	private String busGrade; 	// 버스 등급
	private String maxSeatCnt; 	// 최대 좌석수
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}
	public String getBusLicense() {
		return busLicense;
	}
	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}
	public String getBusGrade() {
		return busGrade;
	}
	public void setBusGrade(String busGrade) {
		this.busGrade = busGrade;
	}
	public String getMaxSeatCnt() {
		return maxSeatCnt;
	}
	public void setMaxSeatCnt(String maxSeatCnt) {
		this.maxSeatCnt = maxSeatCnt;
	}
	
	
}
