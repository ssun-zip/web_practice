package sec1218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ajaxTest2")
public class AjaxTest2 extends HttpServlet{
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
		String result = "";
		//<![CDATA[ ... ]]>는 안에 들어가는 텍스트가 파싱되지 않게 하는 기능
		// html 태그 < > 등... 많은 기호로 둘러쌓여있기 때문에 글자가 파싱이 잘못될수있기 때문에 
		// 파서의 잘못된 파싱을 방지하는 기능 
		PrintWriter writer = response.getWriter();
		result="<main><book>" + 
				"<title><![CDATA[자바 프로그래밍]]></title>" +
				"<writer><![CDATA[저 | 박샘이]]></writer>"
                +"<image><![CDATA[http://localhost:8080/DecemberWeek_3/image/duke.png]]>"+
				"</image>" +"</book>"+
                   "<book>" +"<title><![CDATA[모두의 파이썬]]></title>"+
				"<writer><![CDATA[길벗 저 | 주니샘]]></writer>"+
                      "<image><![CDATA[http://localhost:8080/DecemberWeek_3/image/duke.png]]>"+
                         "</image>" + "</book></main>";

		System.out.println(result);
		writer.print(result);
	}
}
