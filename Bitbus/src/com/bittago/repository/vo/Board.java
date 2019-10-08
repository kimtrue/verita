package com.bittago.repository.vo;

import java.util.Date;

public class Board {
	private int boardNo; 	// 게시글 번호
	private String title; 	// 게시글 제목
	private String content; // 게시글 내용
	private Date regDate; 	// 게시글 작성일
	private int	viewCnt; 	// 조회수
	private int nextNo;
	private String nextTitle;
	private int preNo;
	private String preTitle;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getNextNo() {
		return nextNo;
	}
	public void setNextNo(int nextNo) {
		this.nextNo = nextNo;
	}
	public String getNextTitle() {
		return nextTitle;
	}
	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
	public int getPreNo() {
		return preNo;
	}
	public void setPreNo(int preNo) {
		this.preNo = preNo;
	}
	public String getPreTitle() {
		return preTitle;
	}
	public void setPreTitle(String preTitle) {
		this.preTitle = preTitle;
	}
	
	
	
}
