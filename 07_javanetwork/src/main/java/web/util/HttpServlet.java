package web.util;

public abstract class HttpServlet {
	public abstract void service(HttpServletRequest request, HttpServeletResponse response) throws ServletException;

}
