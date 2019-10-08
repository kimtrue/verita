package com.bittago.repository.vo;

public class ScheduleList {
	private int lineNo;
	private String busLicense;
	private String departure;
	private String arrival;
	private String departureTime;
	private String operatingTime;
	private int adultPrice;
	private int kidPrice;
	private String schDate;
	private String maxSeatCnt;
	
	
	public String getMaxSeatCnt() {
		return maxSeatCnt;
	}
	public void setMaxSeatCnt(String maxSeatCnt) {
		this.maxSeatCnt = maxSeatCnt;
	}
	public String getSchDate() {
		return schDate;
	}
	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}
	public int getLineNo() {
		return lineNo;
	}
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	public String getBusLicense() {
		return busLicense;
	}
	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getOperatingTime() {
		return operatingTime;
	}
	public void setOperatingTime(String operatingTime) {
		this.operatingTime = operatingTime;
	}
	public int getAdultPrice() {
		return adultPrice;
	}
	public void setAdultPrice(int adultPrice) {
		this.adultPrice = adultPrice;
	}
	public int getKidPrice() {
		return kidPrice;
	}
	public void setKidPrice(int kidPrice) {
		this.kidPrice = kidPrice;
	}
	
	
}
