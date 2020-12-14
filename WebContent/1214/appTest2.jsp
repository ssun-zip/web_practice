<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   //appTest1에서 session의 name 과 address를 모두 받는다. 
   		String name = (String)session.getAttribute("name");
   		String address = (String)application.getAttribute("address");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 이름은 <%= name  %> 입니다 </h3>
	<h3> 주소는 <%= address  %> 입니다 </h3>
</body>
</html>