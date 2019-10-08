package com.bittago.repository.vo;

import java.util.Date;

public class Schedule {

	private int schNo;		// 스케줄 번호
	private int lineNo;		// 노선 번호
	private Date schDate;	// 스케줄 해당 날짜
	
	
	public int getSchNo() {
		return schNo;
	}
	public void setSchNo(int schNo) {
		this.schNo = schNo;
	}
	public int getLineNo() {
		return lineNo;
	}
	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
	}
	public Date getSchDate() {
		return schDate;
	}
	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}
	
}
