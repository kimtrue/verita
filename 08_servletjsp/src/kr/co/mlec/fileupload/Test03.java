package kr.co.mlec.fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * 저장되는 경로 바꿔보기(년/월/일/시)
 * 
 * 저장되는 파일 이름 변경 ( 고유한 이름으로 만들기 - UUID)
 *
 */

@WebServlet("/fileupload/test03.do")
public class Test03 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/HH");
		String filePath = "/board" + sdf.format(new Date());
		File file = new File("c:/java/upload" + filePath);
		//경로가 존재하지 않는다면
		if(file.exists() == false) file.mkdirs();

		/**cos 라이브러리를 사용해서 파라미터 값을 받아오자*/
		MultipartRequest request = new MultipartRequest(req, 
				                                         file.getPath(), //파일의 경로 반환  
				                                         1024 * 1024 * 100, 
				                                         "utf-8", 
				                                         new MlecFileRenamePolicy());
		 
		System.out.println("msg:" + request.getParameter("msg"));

		
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
