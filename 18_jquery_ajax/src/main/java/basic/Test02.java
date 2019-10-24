package basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/basic/test02.do")
public class Test02 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json; charset=utf-8");
		//데이터를 json 으로 보내기 위해 map으로 
		Map<String, String> result = new HashMap<>();
		String msg = req.getParameter("msg");
		result.put("msg", msg);
		result.put("code", "200");
		/*
		 *  Map의 데이터를 Json으로 바꾸면
		 * {"msg": msg, "code": "200"}
		*/
		
		
		PrintWriter out = res.getWriter();
		out.println(new Gson().toJson(result));
		out.close();
	}
	
	
}
