package sec1220;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController_1 extends HttpServlet{
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
	       String nextPage = null;
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        // URL에서 요청명을 가져온다.	
	        String action = request.getPathInfo(); 
	        System.out.println("action : " + action);
	      //최초 요청 혹은 회원 조회이면 조회 페이지 - 회원 목록 출력 
	        if(action == null || action.equals("/listMembers.do")) { 
	            System.out.println("최초 요청? 회원 조회??,,,,," + action);
	          //요청에 대해 외원 정보를 조회
	            List<MemberVO> membersList = memberDAO.listMembers(); 
	            System.out.println(membersList);
	          //조회한 정보를 request에 바인딩
	            request.setAttribute("membersList", membersList); 
	            nextPage = "/1220/listMembers.jsp";
	        } // 전송된 회원 정보를 가져와 테이블에 추가하는 역할
	        else if(action.equals("/addMember.do")) {
	            System.out.println("회원 정보를 추가하자,,,,," + action);
	            String id = request.getParameter("id");
	            String pd = request.getParameter("pwd");
	            String name = request.getParameter("name");
	            String email = request.getParameter("email");
	            MemberVO memberVO = new MemberVO(id,pd,name,email);
	          //DAO의 addmember로 DB에 저장
	            memberDAO.addMember(memberVO); 
	          //회원 등록후 다시 회원 목록을 출력 
	            nextPage = "/member/listMembers.do"; 
	        }// 회원 가입창일 경우
	        else if (action.equals("/memberForm.do"))  {
	            System.out.println("회원 가입창으로 이동하자,,,,,"  + action);
	            nextPage = "/1220/memberForm.jsp"; // 해당 경로의 jsp로 포워딩한다.
	        }
	        else {
	            System.out.println("다른 입력이 들어옴..." + action);
	            List<MemberVO> membersList = memberDAO.listMembers();
	            request.setAttribute("membersList", membersList);
	            nextPage = "/1220/listMembers.jsp";
	        }//그 외 다른 action 값은 회원 목록을 출력
	        System.out.println("조건문 다 통과....." + action);
	      //nextPage에 따른 요청명으로 서블릿에 요청
	        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
	        dispatch.forward(request, response); 
	        //컨트롤러에서 표시하고자 하는 JSP로 포워딩
	        //포워딩, 바인딩은 Servlet에서 추후에 설명
	}
}
