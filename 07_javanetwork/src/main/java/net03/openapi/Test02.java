package net03.openapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test02 {
	public static void main(String[] args) {
		try {
			String dan = "https://openapi.naver.com/v1/search/movie.xml?query=%EB%B0%98%EC%A7%80%EC%9D%98%EC%A0%9C%EC%99%95&display=3&start=1&country=US";
			String danUrl = "https://openapi.naver.com/v1/util/shorturl?url=" + dan;
			URL url = new URL(danUrl);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", "qbd8haQjeTzrzafAPufQ");
			con.setRequestProperty("X-Naver-Client-Secret", "bSFnEmT_jd");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while(true) {
				String line = br.readLine();
				if(line ==null) break;
				System.out.println(line);
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
