package net09.webfile;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import web.util.FileUtil;
import web.util.HttpServeletResponse;
import web.util.HttpServletRequest;

public class Test01 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while (true) {
				Socket client = server.accept();
				HttpServletRequest request = new HttpServletRequest(client.getInputStream());
				HttpServeletResponse response = new HttpServeletResponse(client.getOutputStream());
				
				//HTML파일을 전송한다
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println(FileUtil.readFile("C:\\java\\workspace\\07_javanetwork\\src\\WebContent\\html\\test01.html"));
				out.close();
				
				response.send();
				client.close();
				

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
