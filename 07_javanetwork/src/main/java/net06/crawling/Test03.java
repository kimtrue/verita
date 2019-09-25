package net06.crawling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test03 {
	public static void main(String[] args) {
		Test03 t = new Test03();
		t.execute01();
		t.execute02();
		
		
		
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

	private void execute02() {
		/**
		 * 셀레니움을 통해 적용시키기
		 * 동적으로 만들어지는 것에 대한 처리가 안되기 때문에
		 */
		
		init();
		//드라이버가 크롬 하나를 띄울건데 get(url) url을 띄워라
		driver.get("http://localhost:8000/07_javaweb/crawling.html");
		
		WebElement e = driver.findElement(By.cssSelector("#maintitle"));
		System.out.println(e.getText());
		
		//드라이버 사용종료
		driver.quit();
		
	}

	private void execute01() {
		try {
			/**
			 * Jsoup은 html 상에서 변경시키는 코드를 넣어 내용을 넣어주면
			 *  변경된 내용을 갖고오지 못한다
			 *  변경된 정보를 가져오기 위해서는 selenium 라이브러리 활용
			 *  
			 *  selenium 을 사용하기 위한 단계
			 *  1. 라이브러리 다운
			 *     https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59
			 *  
			 *  
			 *  2. 셀레니움 크롬 드라이브 다운
			 *     https://sites.google.com/a/chromium.org/chromedriver/
			 *     window32.zip 다운받았다
			 *     다운받아서 압출풀고  java\bin\crawling 에 넣기
			 *  
			*/
			Document doc = Jsoup.connect("http://localhost:8000/07_javaweb/crawling.html").get();
//			System.out.println(doc.html());
			System.out.println(doc.select("#maintitle").text());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
