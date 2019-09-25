package net08.net.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import web.util.HttpServeletResponse;
import web.util.HttpServletRequest;

public class Quiz04 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				Socket client = server.accept();
				HttpServletRequest request = new HttpServletRequest(client.getInputStream());
				int num = Integer.parseInt(request.getParameter("num"));
				String message = request.getParameter("msg");
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				StringBuffer sb = new StringBuffer();
				for(int i = 0; i < num; i++) {
				 sb.append("<div>"+message+"</div>");
				}
				String msg = "<!DOCTYPE html>"
						+"<html>"
						+"  <head>"
						+"      <meta charset='utf-8'>"
						+"      <title>웹서버 구현</title>"
						+"  </head>"
						+"  <body>"
						+"     <h2>"+sb.toString()+"</h2>"
						+"  </body>"
						+"</html>";
		
				
				
				HttpServeletResponse response = new HttpServeletResponse(
						client.getOutputStream()
						);
				response.setContentType("text/html charset=utf-8");
				PrintWriter out = response.getWriter();
				out.print(msg);
				out.close();
				
				
				response.send();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
