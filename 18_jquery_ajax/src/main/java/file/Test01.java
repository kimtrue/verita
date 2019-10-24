package file;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/file/test01.do")
public class Test01 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/**cos 라이브러리를 사용해서 파라미터 값을 받아오자*/
		MultipartRequest request = new MultipartRequest(
				req, 
				"c:/java/upload", 
				1024 * 1024 * 100, 
				"utf-8", 
				new DefaultFileRenamePolicy());
		 
		//동적으로 바꿔줬다	
		Enumeration<String> names = request.getFileNames();
		// while(이름을 갖고있을 때)
		while (names.hasMoreElements()) {
			String fName = names.nextElement();
			File f = request.getFile(fName);
			if (f != null) {
				String orgName = request.getOriginalFileName(fName);
				System.out.println("원본 파일명 :" + orgName);
			}
		}
		res.setContentType("text/html; charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<h2>성공</h2>");
		out.close();

	}
}
