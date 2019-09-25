package net08.net.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;

public class Quiz02 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8000);
			while(true) {
				Socket client = server.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				
//				String ser = "http://localhost:8000/loop?num=3&msg=hello";
				String[] arr = br.readLine().split(" ")[1].split("\\?");
				
				String message = " ";
				int no = 0;
				if (arr.length == 2) {
					for (String p : arr[1].split("&")) {
						String[] pArr = p.split("=");
						if (pArr[0].equals("num")) {
							no = Integer.parseInt(pArr[1]);
							StringBuffer param = new StringBuffer();
								
						
						} else {
							message = URLDecoder.decode(pArr[1]);
						}
						StringBuffer sb = new StringBuffer();
						for(int i = 0; i < no; i++ ) {
							sb.append("<div>" + message + "</div>");
						}
					}
				}
				
				
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
