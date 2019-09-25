/**
 * lotto 폴더 하위에 1~45번 까지의 이미지 저장하기 
 * 
 * 
 */
package net.url.exam;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Quiz01 {
	private static void imgSave(int no) throws Exception {
		String fName = no + ".png";
		URL url = new URL(
				"http://www.lotto.co.kr/resources/images/lottoball_92/on/"+ fName
				);
		FileOutputStream fos = new FileOutputStream("lotto/" + fName);
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		while(true) {
			int ch = bis.read();
			if(ch == -1) break;
			
			fos.write(ch);
		}
		System.out.println(fName + "저장성공");
		fos.close();
		bis.close();
		
	}
	public static void main(String[] args) {
		//url 이미지 저장시키기 http://www.lotto.co.kr/resources/images/lottoball_92/on/1.png
		
		//데이터를 읽게 할 변수선언
		try {

			File f = new File("lotto");
			if(f.exists()==false) {
				f.mkdirs();
			}
			
			for(int i = 1; i < 46; i++) {
				imgSave(i);
			}
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
