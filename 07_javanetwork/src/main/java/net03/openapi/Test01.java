/**
 *
 * openAPI 나한테 없는것을 내가 그쪽 서버에 있는 것을 갖다 쓰고 싶을 때
 * naver에서 제공하는 것을 기준으로. openAPI 활용하기		
 *
 * 클라이언트 id qbd8haQjeTzrzafAPufQ
 * 클라이언트 시크릿 bSFnEmT_jd
 *
 */
package net03.openapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Test01 {
	public static void main(String[] args) {
		try {
			//한글로 된 것 인코딩작업 해주기. URLEncoder.encode("처리할단어", "처리할방식?utf-8")
//			System.out.println(URLEncoder.encode("자바", "utf-8"));
		   /*
			consol 자바 = %EC%9E%90%EB%B0%94
			naver 자바 = %EC%9E%90%EB%B0%94
			*/
			String blogUrl = "https://openapi.naver.com/v1/search/blog.xml";
//			String movieUrl = "https://openapi.naver.com/v1/search/movie.xml";
			//query=한글 넘어가지 않는다. 한글을 인코딩해줘야한다.
			String text = URLEncoder.encode("자바", "utf-8");
//			String ser = URLEncoder.encode("반지의제왕", "utf-8");
			String query = "query="+text+"&display=3&start=1&sort=date";
//			String query = "query="+ser+"&display=3&start=1&country=US";
			
			String blogPage = blogUrl + "?" + query;
//			String moviePage = movieUrl+"?"+query;
			System.out.println(blogPage);
//			System.out.println(moviePage);
			
			//blog페이지 부르기
			URL url = new URL(blogPage);
//			URL url = new URL(moviePage);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("GET");
			//사용자 인증시 사용
			con.setRequestProperty("X-Naver-Client-Id", "qbd8haQjeTzrzafAPufQ");
			con.setRequestProperty("X-Naver-Client-Secret", "bSFnEmT_jd");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while(true) {
				String line = br.readLine();
				if(line==null) break;
				
				System.out.println(line);
			}
			br.close();
			/*
			https://openapi.naver.com/v1/search/blog.xml?query=%EC%9E%90%EB%B0%94&display=3&start=1&sort=date
				<?xml version="1.0" encoding="UTF-8"?>
			<rss version="2.0"><channel>
			<title>Naver Open API - blog ::'자바'</title>
			<link>https://search.naver.com</link>
				<description>Naver Search Result</description>
				<lastBuildDate>Mon, 02 Sep 2019 16:13:20 +0900</lastBuildDate>
				<total>685893</total><start>1</start><display>3</display>
				<item><title>수원 무료교육국비지원 백엔드&amp;amp;&lt;b&gt;자바&lt;/b&gt;프로그래밍 개발육성과정... </title>
				<link>https://blog.naver.com/q1098?Redirect=Log&amp;logNo=221636335385</link>
					<description>&amp;quot;프론트 엔드&amp;quot; 와 &amp;quot;백엔드&amp;quot; 마스터 하여 &amp;quot;풀스텍 마스터&amp;quot; 가 필요한 시대 &amp;quot;&lt;b&gt;자바&lt;/b&gt;프로그래밍&amp;quot; (Java Programming) 수원&lt;b&gt;자바&lt;/b&gt;프로그래밍 백엔드 개발육성 과정[수원컴퓨터학원] 수원 국비지원 무료교육... </description><bloggername>더휴먼컴퓨터아트아카데미</bloggername><bloggerlink>https://blog.naver.com/q1098</bloggerlink><postdate>20190902</postdate></item><item><title>11~12월 &lt;b&gt;자바&lt;/b&gt;개발자 양성과정 인원 모집(국비무료과정)</title><link>https://blog.naver.com/rhkdvhghtn?Redirect=Log&amp;logNo=221636333333</link><description>＊19년도 &lt;b&gt;자바&lt;/b&gt;개발자 국비교육 하반기 인원 모집합니다 11월(오전타임)/12월(오후타임) ※강의시간 잘... &lt;b&gt;자바&lt;/b&gt;개발자 국비지원교육 신청 및 상세한 상담을 받고자 하시는 분들은 설문지 남겨주시면 1:1... </description><bloggername>『최대리의 Official Story』</bloggername><bloggerlink>https://blog.naver.com/rhkdvhghtn</bloggerlink><postdate>20190902</postdate></item><item><title>&lt;b&gt;자바&lt;/b&gt; 개발자, 퍼블리셔 사원-부장급</title><link>https://blog.naver.com/leeseob64?Redirect=Log&amp;logNo=221636332163</link><description>1 : &lt;b&gt;자바&lt;/b&gt; 개발자 [담당업무] - 웹, 앱 개발 - 쇼핑몰 개발 및 운영 [요구조건] - 정보처리기사... 2 : 퍼블리셔 [담당업무] - 본사 개발참여 및 프로젝트 진행 - &lt;b&gt;자바&lt;/b&gt; 스크립트, 웹표준 작업 [요구조건]... </description><bloggername>디퍼런트에이치알 대표컨설턴트</bloggername><bloggerlink>https://blog.naver.com/leeseob64</bloggerlink><postdate>20190902</postdate></item></channel></rss>
             */
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		/*
		query	string	Y	-	검색을 원하는 문자열로서 UTF-8로 인코딩한다.
		display	integer	N	10(기본값),100(최대)	검색 결과 출력 건수 지정
		start	integer	N	1(기본값), 1000(최대)	검색 시작 위치로 최대 1000까지 가능
		sort    string	N	sim(기본값), date	정렬 옵션: sim (유사도순), date (날짜순)
		*/
		
		
		
		
	}

}
