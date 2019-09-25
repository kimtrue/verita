package web.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HttpServeletResponse {
	
	/* pw가 sw에 저장되는 것을 확인
	public static void main(String[] args) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		pw.print("html");
		pw.print("TEST");
		pw.close();
		System.out.println(sw.toString());
	}*/
		

	private OutputStream out;
	private String contentType;
	private StringWriter sw = new StringWriter();
	//pw의 뭔가가출력이 되면 sw라는 공간에 저장시킨다
	private PrintWriter pw = new PrintWriter(sw);
	
	
	public HttpServeletResponse(OutputStream out) {
		this.out = out;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;

	}


	public PrintWriter getWriter() {
		return pw;
	}


	public void send() throws Exception {
		String msg = sw.toString();
		String startLine = "HTTP/1.1 200 OK\r\n";
		String header = "Content-Type: "+ contentType +"\r\n"
				    	+ "Content-Length: " + msg.getBytes("utf-8").length + "\r\n\r\n"; //공백을 위해 줄넘김 두번
		String sendData = startLine + header + msg;
			
		//여기 트라이 캐치로 잡아줘야하는데 응답하는 곳에서 처리하게 던진다.
		out.write(sendData.getBytes("utf-8"));
		out.close();
		
	}


	public void sendByte(byte[] buffer) throws Exception {
		String startLine = "HTTP/1.1 200 OK\r\n";
		String header = "Content-Type: "+ contentType +"\r\n"
				    	+ "Content-Length: " + buffer.length + "\r\n\r\n"; //공백을 위해 줄넘김 두번
		//여기 트라이 캐치로 잡아줘야하는데 응답하는 곳에서 처리하게 던진다.
		out.write(startLine.getBytes());
		out.write(header.getBytes());
		out.write(buffer);
		out.close();
		
	}




	
	
	
	
	

}
