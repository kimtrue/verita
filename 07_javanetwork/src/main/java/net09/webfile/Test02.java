package net09.webfile;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import web.util.FileUtil;
import web.util.HttpServeletResponse;
import web.util.HttpServletRequest;

public class Test02 {
	public static void main(String[] args) {
		http://localhost:8000/test.do?name=chloe&msg=it%27sgoodtoseeyou
		try {
			ServerSocket server = new ServerSocket(8000);
			while (true) {
				Socket client = server.accept();
				HttpServletRequest request = new HttpServletRequest(client.getInputStream());
				HttpServeletResponse response = new HttpServeletResponse(client.getOutputStream());
				
				
				String content = FileUtil.readFile("C:\\java\\workspace\\07_javanetwork\\src\\WebContent\\html\\test02.html");
				//사용자가 이름고ㅏ 메세지를 보내겠다
				String name = request.getParameter("name");
				content = content.replace("#name", name);
				String msg = request.getParameter("msg");
				content = content.replace("#msg", msg);
				
				
				//HTML파일을 전송한다
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println(content);
				out.close();
				
				response.send();
				client.close();
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
