package net06.crawling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test04 {
	public static void main(String[] args) {
		Test04 t = new Test04();
		try {
		t.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	//셀레니움 사용시의 기본 설정
	private WebDriver driver; // 컴퓨터의 브라우져를 구동할수 있게 하는 도구
	private void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\java\\bin\\crawling\\chromedriver.exe");
		//chrome을 사용하기 위해서 설정
		driver = new ChromeDriver();
		//옵션 설정
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	private void execute() throws Exception {
		/**
		 * 셀레니움을 통해 적용시키기
		 * 동적으로 만들어지는 것에 대한 처리가 안되기 때문에
		 */
		
		init();
		//드라이버가 크롬 하나를 띄울건데 get(url) url을 띄워라
//		driver.get("https://logins.daum.net/accounts/toploginform.do");
//		driver.findElement(By.id("id")).sendKeys("kim_jin_sil");
//		driver.findElement(By.id("inputPwd")).sendKeys("jhjs070431^^");
//		driver.findElement(By.id("loginSubmit")).click();
				
		
		
		
//			Thread.sleep(3000);
		

		driver.get("http://ticket.interpark.com/Ticket/Goods/GoodsInfo.asp?GoodsCode=19011684");
		
		//검색어 입력
		driver.findElement(By.id(""));
		driver.findElement(By.cssSelector(".btn_search")).click();
		

		
		driver.findElement(By.cssSelector("#playend_list > tr:nth-child(1) > td.btnArea")).click();

		

		
		
		
		//드라이버 사용종료
//		driver.quit();
		
	}

	

}
