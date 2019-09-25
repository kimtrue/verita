package ch18_exception.exam;

public class JavaBookSale implements Sale {
	private int price;
	private int percent;
	private String productName;
	
	JavaBookSale () { 
		price = 0;
		percent = 0;
		productName = null;
		
	}
	
	JavaBookSale (String productName, int price, int percent)  throws PriceException {
	  
		   if(price < 0 || percent >= 50) {
			   String msg = "가격 또는 할인율이 잘못되었습니다";
			   throw new PriceException(msg);
		   }
	   
		
		this.price = price;
		this.percent = percent;
		this.productName = productName;
		

	}
	
	
	
	
	 public int getPrice() {
		return price;
	}




	public void setPrice(int price) {
		this.price = price;
	}




	public int getPercent() {
		return percent;
	}




	public void setPercent(int percent) {
		this.percent = percent;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public int calculatePrice() {
		 return 0;
	 }
	
	public String toString(){
		return "책제목 : "+ this.getProductName()+ 
				"\n가격 : " + this.getPrice() + 
				"원 \n할인율 : " + this.getPercent() + "%";
		
	}
	
	
	
	
}
