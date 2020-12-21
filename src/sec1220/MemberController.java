package sec1220;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// membersList 호출하여 회원 정보를 ArrayList 로 반환
// request 조회한회원 정보를 membersList 속성 이름에 바인딩 
// RequestDispatcher 클래스에서 listMembers.jsp 로 포워딩
// member.do 서블렛을 통해 돌려야 정보를 DAO 와 listMembers.jsp 로 정보가 보내진다.

//@WebServlet("/member.do")
public class MemberController extends HttpServlet{
private static final long serialVersionUID = 1L;
	MemberDAO memberDAO; 
	public void init() throws ServletException {
		memberDAO = new MemberDAO(); // 객체 초기화 
	}
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
		// 요청에 의해 회원 정보를 조회 
		List<MemberVO> membersList= memberDAO.listMembers();
		//조회한 정보를 request에 바인딩 
		request.setAttribute("membersList", membersList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/1220/listMembers.jsp");
		//컨트롤러에서 표시하고자 하는 JSP 로 포워딩
		dispatcher.forward(request, response);
	}
}
