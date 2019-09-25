package net09.webfile;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import web.util.FileUtil;
import web.util.HttpServeletResponse;
import web.util.HttpServletRequest;

public class Test03 {
	public static void main(String[] args) {
		http://localhost:8000/test.do?name=chloe&msg=it%27sgoodtoseeyou
		try {
			ServerSocket server = new ServerSocket(8000);
			while (true) {
				Socket client = server.accept();
				HttpServletRequest request = new HttpServletRequest(client.getInputStream());
				HttpServeletResponse response = new HttpServeletResponse(client.getOutputStream());
				
				String uri = request.getRequestURI();
				if(uri == null) continue;
				System.out.println("요청 URI : " + uri);
				
				if("/favicon.ico".equals(uri)) continue;
				
				//css에 대한 요청
				if (uri.endsWith(".css")) {
					response.setContentType("text/css; charset=utf-8");
					PrintWriter out = response.getWriter();
					// 슬래쉬 자르고 경로를 읽어야해서
					out.println(FileUtil.readFile(uri.substring(1)));
					out.close();

					response.send();
					continue;

				}
				//이미지에대한 요청
				if (uri.endsWith(".jpg") || uri.endsWith(".jpeg") || uri.endsWith(".png") || uri.endsWith(".gif")) {
					response.setContentType("image/jpeg");
					
					byte[] buffer = FileUtil.readByteFile(uri.substring(1));
					response.sendByte(buffer);
					continue;
					
				}
				String content = FileUtil.readFile("C:\\java\\workspace\\07_javanetwork\\WebContent\\html\\test03.html");
				//사용자가 이름고ㅏ 메세지를 보내겠다
				String title = request.getParameter("title");
				content = content.replace("#title", title);
						
				
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
