package net08.net.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;

import web.util.HttpServletRequest;

public class Quiz03 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				Socket client = server.accept();
				HttpServletRequest request = new HttpServletRequest(client.getInputStream());
				int num = Integer.parseInt(request.getParameter("num"));
				String msg = request.getParameter("msg");
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
				StringBuffer sb = new StringBuffer();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
