package sec1218;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem")
public class MemberServlet extends HttpServlet{
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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		String id = (String)request.getParameter("id");
		System.out.println("id = " + id);
		MemberDAO_1 memberDAO = new MemberDAO_1();
		boolean overlappedId = memberDAO.overlappedID(id); // id중복 여부 체크
		
        // 결과를 메세지로 전송.
		if(overlappedId == true) {
			writer.print("not_usable");
		} else {
			writer.print("usable");
		}
	}
}
