package com.bittago.repository.vo;

import java.util.Date;
import java.util.List;

public class Reservation {

	private int rsvNo; 		    	// 예약번호
	private int schNo;		    	// 스케줄 번호
	private int userNo; 	    	// 회원번호
	private int nonuserNo; 	    	// 비회원번호
	private int adultsCnt; 	    	// 성인 인원수
	private int kidsCnt; 	    	// 아동 인원수
	private int payment; 	    	// 총 버스 운임료
	private Date rsvDate;	   	 	// 예약일
	private int rsvState;	   		// 예매(0), 취소(1)상태
	private String busGrade;		// 버스등급
	private int seatNo;				// 좌석번호
	private String departure;		// 출발지
	
	public String getBusGrade() {
		return busGrade;
	}
	public void setBusGrade(String busGrade) {
		this.busGrade = busGrade;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
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
	public String getSchDate() {
		return schDate;
	}
	public void setSchDate(String schDate) {
		this.schDate = schDate;
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
	private String arrival;			// 도착지
	private String schDate;			// 출발일
	private String departureTime;	// 출발시간
	private String operatingTime;	// 운행시간
	
	public int getRsvState() {
		return rsvState;
	}
	public void setRsvState(int rsvState) {
		this.rsvState = rsvState;
	}
	public Date getRsvDate() {
		return rsvDate;
	}
	public void setRsvDate(Date rsvDate) {
		this.rsvDate = rsvDate;
	}
	public int getRsvNo() {
		return rsvNo;
	}
	public void setRsvNo(int rsvNo) {
		this.rsvNo = rsvNo;
	}
	public int getSchNo() {
		return schNo;
	}
	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getNonuserNo() {
		return nonuserNo;
	}
	public void setNonuserNo(int nonuserNo) {
		this.nonuserNo = nonuserNo;
	}
	public int getAdultsCnt() {
		return adultsCnt;
	}
	public void setAdultsCnt(int adultsCnt) {
		this.adultsCnt = adultsCnt;
	}
	public int getKidsCnt() {
		return kidsCnt;
	}
	public void setKidsCnt(int kidsCnt) {
		this.kidsCnt = kidsCnt;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	
}
