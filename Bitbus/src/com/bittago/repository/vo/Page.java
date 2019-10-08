package com.bittago.repository.vo;

public class Page {
	private int pageNo;
	private int listSize;
	private String searchType;
	private String keyWord;
	
	public Page() {
		this(1, 10);
	}
	public Page(int pageNo) {
		this(pageNo, 10);
		}
	public Page(int pageNo, int listSize) {
		this.pageNo = pageNo;
		this.listSize = listSize;
	}
	
	public Page(int pageNo, String searchType, String keyWord) {
		this(pageNo, 10);
		this.searchType = searchType;
		this.keyWord = keyWord;
	}
	
	public Page(int pageNo, int listSize, String searchType, String keyWord) {
		this(pageNo, listSize);
		this.searchType = searchType;
		this.keyWord = keyWord;
	}
	
	
	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	
	

	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	// #{begin}
	public int getBegin() {
		return (pageNo - 1) * listSize + 1;
	}
	
	// #{end}
	public int getEnd() {
		return pageNo * listSize;
	}
	
	
	public static void main(String[] args) {
		int listSize = 5;
		for (int pageNo =1; pageNo < 11; pageNo++) {
		Page p1 = new Page(pageNo, listSize);
	
		System.out.println(p1.getPageNo() + "-" +p1.getBegin() + "-" + p1.getEnd() );
		}
	}
}
