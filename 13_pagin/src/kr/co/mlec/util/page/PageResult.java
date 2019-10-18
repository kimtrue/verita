package kr.co.mlec.util.page;

public class PageResult {
	private int pageNo;
	//전체 게시글 수 
	private int count;
	
	private int beginPage;
	private int endPage;
	
	private boolean prev;
	private boolean next;
	
	public PageResult(int pageNo, int count) {
		this(pageNo, count, 10, 10);
		
	}
	public PageResult(int pageNo, int count, int listSize, int tabSize) {
		this.pageNo = pageNo;
		this.count = count;

		int lastPage = (int) Math.ceil(count / (double)listSize);// 마지막 페이지
		// 목록하단 페이지 블럭 구해보자
		int currTab = (pageNo - 1) / tabSize + 1;// 현재 페이지 블럭넘버 구하기
		this.beginPage = (currTab - 1) * tabSize + 1;
		this.endPage = currTab * tabSize;
		if (endPage > lastPage)
			endPage = lastPage;

		
		this.prev = beginPage != 1;// 1페이지 일 때 전으로 가면 안되고
		this.next = endPage != lastPage;// 마지막 페이지 일때 다음으로 넘기면 안되니까
	}
	
	public int getPageNo() {return pageNo;}
	public int getCount() {return count;}
	public int getBeginPage() {	return beginPage;}
	public int getEndPage() {return endPage;}
	public boolean getPrev() {return prev;}
	public boolean getNext() {return next;}

}
