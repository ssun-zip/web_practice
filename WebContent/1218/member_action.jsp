<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>       
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@page import = "sec1218.*, java.util.*" %>

<%
  request.setCharacterEncoding("utf-8");
%>

<html>
<head>
<meta charset="UTF-8">

<%--  memberBean 객체를 생성해서 정보를 저장한다.  --%>
<jsp:useBean id = "m" class = "sec1218.MemberBean" />
<jsp:setProperty name = "m" property = "*" />
<%-- memberForm에서의 정보를 전달받아 현 데이터안에 넣는다  
		memDAO객체에다가 클래스에서 받아온 addMember와 listMembers()를 담고 정보 포워딩 
	 --%>

<%
	MemberDAO memDAO = new MemberDAO();
	memDAO.addMember(m);
	List membersList = memDAO.listMembers();
	request.setAttribute("membersList", membersList);
%>

</head>
<body>
	<jsp:forward page = "membersList.jsp"/>
</body>
</html>