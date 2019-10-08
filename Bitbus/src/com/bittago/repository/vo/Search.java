package com.bittago.repository.vo;

import java.util.Date;

public class Search {

	private int departure; //출발 터미널 번호
	private int arrival; //도착 터미널 번호
	private Date schDate;
	
	public Search() {
		this(0, 0);
	}
	
	public Search(int departure, int arrival) {
		this.departure = departure;
		this.arrival = arrival;
	}
	
	public Search(int departure, int arrival, Date schDate) {
		this.departure = departure;
		this.arrival = arrival;
		this.schDate = schDate;
	}
	
	
	public Date getSchDate() {
		return schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public int getDeparture() {
		return departure;
	}
	public void setDeparture(int departure) {
		this.departure = departure;
	}
	public int getArrival() {
		return arrival;
	}
	public void setArrival(int arrival) {
		this.arrival = arrival;
	}
	
	
	
	
	
	
	
}
