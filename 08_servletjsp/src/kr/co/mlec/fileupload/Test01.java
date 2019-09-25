package kr.co.mlec.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * 
 * cos 라이브러리 사용해서 파일 업로드 처리
 * https://mvnrepository.com/artifact/servlets.com/cos/05Nov2002
 * 
 * 읽은 스트림의 내용을 파싱.                         
 *                                               (req를 주면 req.getInputStream()기능을 한다 , 
 *                                                업로드할 디렉토리경로(업로드 한 파일의 저장할 경로), 
 *                                                용량제한(1024 * 1024 * 100 은 100mb라는 뜻), 
 *                                                파라미터를 인코딩 할 방식,
 *                                                파일이 저장 될 때 이름 정책지정(같은 이름이 있을 때 처리를 어떻게 해야할 것인지)
 *                                                 new DefaultFileRenamePolicy() - 같은 이름이 있을 때 숫자값을 붙여준다 ) 
 * MultipartRequest request = new MultipartRequest(request, 
 *                                                 saveDirectory, 
 *                                                 maxPostSize, 
 *                                                 encoding, 
 *                                                 policy)
 * 
 * 
 * 
 * file 테이블 만들기 
 *  필요한 컬럼 : 
 *   파일 넘버, 게시판 넘버, 사용자가 업로드한 이름, 시스템상 저장된 이름(policy로 이름이 변경 될 수 있기 때문에), 파일종류, 파일 사이즈, 저장된 경로..
 *  
 *  저장된 경로의 규칙:
 *  - 파일의 하위 폴더를 만들어 기능별로..
 *  - board, user,... user/year/month/day/time...
 *  c:/java/upload는 고정. user/year/month/day/time.. 의 경로는 바뀔 수 있으니까 
 *   바뀔 수 있는 경로는 패스로 준다.
 *
 *
 */

@WebServlet("/fileupload/test01.do")
public class Test01 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/* <form ...enctype="multipart/form-data" /> 일 경우
		 * 날아오는 파라미터의 값이 달라 뽑아 올 수 없어 null이 뜬다
		System.out.println("msg:" + req.getParameter("msg"));
		System.out.println("attach:" + req.getParameter("attach"));
		 */
		
		//cos 라이브러리를 사용해서 파라미터 값을 받아오자
		MultipartRequest request = new MultipartRequest(req, "c:/java/upload", 1024 * 1024 * 100, "utf-8", new DefaultFileRenamePolicy());
		 
		System.out.println("msg:" + request.getParameter("msg"));
		
		/**파일 정보 저장시 필요한 값 추출하기*/
		//request.getFile(name) jsp에서 파일 타입을 준 name값을 준다
		File f = request.getFile("attach1"); 
		//f == null 이면 파일을 선택하지 않은 경우. 
		if(f != null) {
			System.out.println("파일의 크기 :" + f.length());
			
			//원본 파일의 이름과, 시스템에 저장되는 이름 얻기
//			request.getOriginalFileName(name) name자리에 jsp에서 파일 타입을 준 name값을 준다
			
			String orgName = request.getOriginalFileName("attach");
			System.out.println("원본 파일명 :" + orgName);
			String systemName = request.getFilesystemName("attach");
			System.out.println("파일 시스템 저장 파일명:" + systemName);
			
		}
		
		System.out.println("파일 업로드 성공");
		
		
		
		
		
	}
	
	

	
	/*
	 * 파일에서 전송되는 내용 확인용
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			PrintWriter out = res.getWriter();
			//사용자가 보낸 정보를 읽는다
			InputStream in = req.getInputStream();
			//inputstream을 읽는다
			Scanner sc = new Scanner(in);
			while(sc.hasNextLine()) {
				out.println(sc.nextLine());
			}
			
			out.close();
	}
	*/
	

}
