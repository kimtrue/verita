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

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;

/**
 * 썸네일 생성하기
 * 
 * - 자바의 라이브러리 활용
 * 
 * - 오픈 라이브러리(Thumbnailator) 활용 . 
 *    이것을 사용하겠다
 *    https://mvnrepository.com/artifact/net.coobird/thumbnailator/0.4.8 jar 받아서 lib에 넣어줘라
 *   
 *   
 *  썸네일 : 파일이 있을 때 만든다.  
 *         테이블에 따로 관리하지 않는다
 *         규칙을 준다.
 *         - thumb-a.jpg
 *         - thumb 이라는 폴더를 하나 만들어준다
 *
 * 
 */

@WebServlet("/fileupload/test04.do")
public class Test04 extends HttpServlet{

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
				
			//파일이 있다면 썸네일 이미지를 생성하기
//				Thumbnails.of(new File(원본정보, 시스템저장된이름))
				// builder.size 이미지의 크기
				//outputFormat("확장자명") 저장될 파일 포멧
				//toFile(저장경로)
				Thumbnails.of(new File(f.getParent(), systemName)).
				                       size(300, 200).
				                       outputFormat("png").
				                       toFile(new File(f.getParent(), "thumb_"+systemName));
				
				
			}
		}

	}
}
