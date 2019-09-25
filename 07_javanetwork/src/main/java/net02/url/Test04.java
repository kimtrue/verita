package net02.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Test04 {
	public static void main(String[] args) {
		try {
			/*클라이언트*/
			//get방식
			URL url = new URL(
					"http://localhost:8000/07_javaweb/net/url/test04?id=test"
					);
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				
				
				System.out.println(line);
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
