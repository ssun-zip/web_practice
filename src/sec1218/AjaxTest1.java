package sec1218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ajaxTest1")
public class AjaxTest1 extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		String param = (String) request.getParameter("param");
		// param의 내용을 console창에 출력 
		System.out.println("param = " + param);
		PrintWriter writer = response.getWriter();
		//화면에 print할 내용 
		writer.print("서버입니다");
	}
}
