package kr.co.mlec.repository.vo;

public class Page {
	//아무것도 없으면 default로 1설정
	private int pageNo = 1;
	private int listSize;
	
	public Page() {
		// 페이지번호는 1, 목록사이즈는 10 디폴트값.. 값을 주지 않을 때
		this(1, 10);
	}

	public Page(int pageNo) {
		this(pageNo, 10);
	}

	public Page(int pageNo, int listSize) {
		this.pageNo = pageNo;
		this.listSize = listSize;
	}
	
	//페이지번호 설정
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	
	
	
	
	//마이바티스에서 사용하려고. #{begin} 하면 getBegin()에서 찾는다
	public int getBegin() {
		return (pageNo - 1) * listSize + 1;
	}
	public int getEnd() {
		return pageNo * listSize;
	}
	
	
	
	
	public static void main(String[] args) {
//		int pageNo = 5;
		// 5면 시작은 41 - 50
		//1 - 10 페이지의 환경
		
		//목록사이즈 바꾸기
		int listSize = 5;

		for (int pageNo = 1; pageNo < 11; pageNo++) {
			Page p1 = new Page(pageNo, listSize);
			
			System.out.println(p1.getPageNo() + " " +p1.getBegin() + "-" + p1.getEnd());
		}
	}
	
}
