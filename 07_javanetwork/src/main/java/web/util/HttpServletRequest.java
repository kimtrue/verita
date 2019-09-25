package web.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class HttpServletRequest {
	private InputStream in;
	private String method;
	private String requestURI;
	private String queryString;
	
	//parameter no=1&pass=123
	private Map<String, String>paramMap = new HashMap<>(); 
	
	public HttpServletRequest(InputStream in) throws Exception {
		this.in = in;
		//시작라인 분석 및 파라미터 처리
		init();
	}
	private void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
		String startLine = br.readLine();
		if(startLine == null) return;
		
		String[] arr = startLine.split(" ");
		method = arr[0];
		
		//GET : arr[1] /board/delete.do?...
		//POST : arr[1] /board/delete.do
		
		String[] uriArr = arr[1].split("\\?");
		requestURI = uriArr[0];
		
		//GET방식일때만 해당
		if(uriArr.length == 2) {
			queryString = uriArr[1];
			//파라미터 처리. GET이나 POST 둘 다 처리가 똑같으니까
			setParamMap();
		}
		
		//POST방식
		//헤더값 소진시키기
		while (true) {
			String line = br.readLine();
			if ("".equals(line))break;
		}
		// POST방식일 경우 BODY에 있는 파라미터 읽기
		if ("POST".equals(method)) {
			String bodyParam = "";
			// br이 읽을 준비가 되었다면
			while (br.ready()) {
				int ch = br.read();
				bodyParam += (char) ch;
			}
			if (bodyParam.length() > 0) {
				queryString = bodyParam;
				setParamMap();
			}
		}

	}

	private void setParamMap() throws Exception {
		// 들어온 파라미터에 대한 정보를 공통으로 파싱해야하니까
		// queryString -> no=1&pass=123
		String[] params = queryString.split("&");
		for (String p : params) {
			// p -> no=1
			// p -> commentNo=123

			// id=&name=abc id값이 없을 때..
			String[] data = p.split("=");
			if (data.length == 2) {
				paramMap.put(data[0], URLDecoder.decode(data[1], "utf-8"));
			} else {
				paramMap.put(data[0], "");
			}
		}
	}

	public InputStream getIn() {
		return in;
	}

	public String getMethod() {
		return method;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public String getQueryString() {
		return queryString;
	}

	public Map<String, String> getParamMap() {
		return paramMap;
	}
	
	
	public String getParameter(String key) {
		return paramMap.get(key);
	}
	
	
	
	
	

}
