package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.common.db.MyAppSqlConfig;
import kr.co.mlec.repository.dao.MemberDAO;

@WebServlet("/basic/test06.do")
public class Test06 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     //결과값 보내주기 공유개념 X
		res.setContentType("text/html; charset=utf-8");
		String id = req.getParameter("id");
		
		MemberDAO dao = MyAppSqlConfig.getSqlSessionInstance().getMapper(MemberDAO.class);
		
		int cnt = dao.selectIdCount(id);
		PrintWriter out = res.getWriter();
		//cnt == 0 이면 사용할 수 있는 아이디
//		out.println(cnt == 0 ? "사용할 수 있는 아이디입니다" : "중복된 아이디입니다");
		out.println(cnt);
		out.close();
		
	}
	

}
