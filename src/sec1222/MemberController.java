package sec1222;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/member/*")
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
	       String nextPage = null;
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        // URL에서 요청명을 가져온다.	
	        String action = request.getPathInfo(); 
	        System.out.println("action : " + action);
	      //최초 요청 혹은 회원 조회이면 조회 페이지 - 회원 목록 출력 
	        if(action == null || action.equals("/listMembers.do")) { 
	          //요청에 대해 외원 정보를 조회
	            List<MemberVO> membersList = memberDAO.listMembers(); 
	          //조회한 정보를 request에 바인딩
	            request.setAttribute("membersList", membersList); 
	            nextPage = "/1222/listMembers.jsp";
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
	            request.setAttribute("msg", "addMember");
	          //회원 등록후 다시 회원 목록을 출력 
	            nextPage = "/member/listMembers.do"; 
	        }// 회원 가입창일 경우
	        else if (action.equals("/memberForm.do"))  {
	            nextPage = "/1222/memberForm.jsp"; // 해당 경로의 jsp로 포워딩한다.
	        } // 회원 정보로요청 시 ID 로 회원 정보를 조회한 후 수정 창으로 포워딩 
	        else if(action.equals("/modMembersForm.do")){
	        	String id = request.getParameter("id");
	        	MemberVO memInfo = memberDAO.findMember(id);
	        	request.setAttribute("memInfo", memInfo);
	        	nextPage = "/1222/modMemberForm.jsp";
	        	// 회원 ID를 SQL 문으로 전달해 테이블의 회원 정보를 삭제 
	        } else if (action.equals("/modMember.do")) {
	        	String id = request.getParameter("id");
	        	String pwd = request.getParameter("pwd");
	        	String name = request.getParameter("name");
	        	String email = request.getParameter("email");
	        	MemberVO memberVO = new MemberVO(id, pwd, name, email);
	        	memberDAO.modMember(memberVO);
	        	request.setAttribute("ms", "modified");
	        	nextPage = "/member/listMembers.do";
	        }else if (action.equals("/delMember.do")){
	        
	        	// 삭제할 아이디를 받아옵니다. 
	        	String id = request.getParameter("id");
	        	memberDAO.delMember(id);
	        	// 목록창에 삭제 작업완료 메세지를 전달 
	        	request.setAttribute("msg", "deleted");
	        	nextPage = "/member/listMembers.do";
	        	
	        } else {
	            List<MemberVO> membersList = memberDAO.listMembers();
	            // membersList 에 membersList 를 바인딩해서 
	            request.setAttribute("membersList", membersList);
	            nextPage = "/1222/listMembers.jsp";
	        }
	      
	        RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
	        dispatch.forward(request, response); 
	        //nextPage에 따른 요청명으로 서블릿에 요청
	        //컨트롤러에서 표시하고자 하는 JSP로 포워딩
	        //포워딩, 바인딩은 Servlet에서 추후에 설명
	}
}
