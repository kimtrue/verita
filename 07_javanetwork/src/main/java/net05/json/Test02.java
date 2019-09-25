package net05.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.google.gson.Gson;

public class Test02 {
	public static void main(String[] args) {
		https://search.naver.com/search.naver?where=post&sm=tab_jum&query=오픈
			try {
				String blogUrl = "https://openapi.naver.com/v1/search/blog";
				String text = URLEncoder.encode("자바", "utf-8");
				String query = "query=" + text + "&display=3&start=1&genre=4&country=US";
				String blogPage = blogUrl + "?" + query;
				
				
				
				URL url = new URL(blogPage);
				HttpURLConnection con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("X-Naver-Client-Id", "qbd8haQjeTzrzafAPufQ");
				con.setRequestProperty("X-Naver-Client-Secret", "bSFnEmT_jd");
				
				BufferedReader br = new BufferedReader(
						new InputStreamReader(con.getInputStream())
				);
				
				//담아주기
				NaverBlog naver = new Gson().fromJson(br, NaverBlog.class);
			    List<Blog> list = naver.getItems();   
			    for(Blog b : list) {
			    	System.out.println(
			    			b.getTitle() + "\t" + b.getLink() + "\t" + b.getDescription()
			    			);
			    }
				br.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
