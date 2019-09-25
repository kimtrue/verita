package net05.json;

public class Address {
	private String postNo;
	private String basic;
	private String detail;
	
	protected String getDetail() {
		return detail;
	}
	protected void setDetail(String detail) {
		this.detail = detail;
	}
	protected String getPostNo() {
		return postNo;
	}
	protected void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	protected String getBasic() {
		return basic;
	}
	protected void setBasic(String basic) {
		this.basic = basic;
	}

}
