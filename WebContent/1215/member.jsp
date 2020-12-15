<%@page import="java.beans.beancontext.BeanContextMembershipListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    import = "java.util.*"
    import = "sec1215.*"
    pageEncoding="UTF-8"%>
    <!-- 1215 java package file 에서 정보를 불러온다  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1 {
		text-align: center;
	}
</style>
</head>
<body>
	<h1> 회원 정보 출력창 </h1>
	<%
		request.setCharacterEncoding("utf-8");
		//search.jsp 에서 조회하고 싶은 이름을 받아온다 
		String _name = request.getParameter("name");
		MemberVO memberVO = new MemberVO();
		// 생성자 정보에 주어진 이름을 넣어 해당 내용을 찾는다. 
		memberVO.setName(_name);
		MemberDAO dao = new MemberDAO();
		// name 이 가진 정보의 리스트를 불러온다 
		List memberList = dao.listMembers(memberVO);
	%>
	<table border = '1' width = '800' align = 'center'>
		<tr align = 'center' bgcolor = '#FFFF66'>
			<td> 아이디 </td>
			<td> password </td>
			<td> name </td>
			<td> email </td>
			<td> Join Date </td>
		</tr>
		<%
			for(int i = 0; i < memberList.size(); i++) {
				MemberVO vo = (MemberVO) memberList.get(i);
				String id = vo.getId();
				String pwd = vo.getPwd();
				String name = vo.getName();
				String email = vo.getEmail();
				Date joinDate = vo.getJoinDate();
		%>
		<tr align = center>
			<td> <%= id %> </td>
			<td> <%= pwd %> </td>
			<td> <%= name %> </td>
			<td> <%= email %> </td>
			<td> <%= joinDate %> </td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>