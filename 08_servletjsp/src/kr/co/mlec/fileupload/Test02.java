package kr.co.mlec.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 
 * 
 *
 */

@WebServlet("/fileupload/test02.do")
public class Test02 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/**cos 라이브러리를 사용해서 파라미터 값을 받아오자*/
		MultipartRequest request = new MultipartRequest(req, "c:/java/upload", 1024 * 1024 * 100, "utf-8", new DefaultFileRenamePolicy());
		 
		System.out.println("msg:" + request.getParameter("msg"));
			
		
	/**	
	 *  동적인 방식이다 인풋 네임이 다를 수 있으니까..
	 *  
		//이름의 숫자만 다르니까 ..  for(int i = 1; i < 6; i++) { }
		for(int i = 1; i < 6; i++) { 
		 String fName = "attach" + i;
			
			File f = request.getFile(fName);

			if (f != null) {
				
				System.out.println("파일의 크기 :" + f.length());
				
				String orgName = request.getOriginalFileName(fName);
				System.out.println("원본 파일명 :" + orgName);
				 시스템에 저장된 이름 받기 
				String systemName = request.getFilesystemName(fName);
				System.out.println("파일 시스템 저장 파일명:" + systemName);

			}
		}
		System.out.println("파일 업로드 성공");
	 */
		
	//동적으로 바꿔줬다	
		Enumeration<String> names = request.getFileNames();
		// while(이름을 갖고있을 때)
		while (names.hasMoreElements()) {
			String fName = names.nextElement();
			File f = request.getFile(fName);

			if (f != null) {
				System.out.println("파일의 크기 :" + f.length());
				String orgName = request.getOriginalFileName(fName);
				System.out.println("원본 파일명 :" + orgName);
				// 시스템에 저장된 이름 받기
				String systemName = request.getFilesystemName(fName);
				System.out.println("파일 시스템 저장 파일명:" + systemName);
			}
		}

	}
}
