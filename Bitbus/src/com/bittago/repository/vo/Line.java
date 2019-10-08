package com.bittago.repository.vo;

public class Line {

	private int lineNo; 			// 노선번호
	private int busNo; 				// 버스 차량번호
	private String departure; 		// 출발지
	private String arrival; 		// 도착지
	private String departureTime; 	// 출발시간
	private String operatingTime; 	// 운행시간
	private int adultPrice; 		// 성인 버스 운임료
	private int kidPrice; 			// 아동 버스 운임료
	private String schDate; 		// 버스출발 날짜, 쿼리문출력을 위한 변수
	private String busLicense;		// 버스 차량번호
	private String maxSeatCnt;		// 버스 총 좌석수
	
	
	public String getBusLicense() {
		return busLicense;
	}
	public void setBusLicense(String busLicense) {
		this.busLicense = busLicense;
	}
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
	public int getBusNo() {
		return busNo;
	}
	public void setBusNo(int busNo) {
		this.busNo = busNo;
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
