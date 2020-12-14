<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    session.setAttribute("name","이순신");
    application.setAttribute("address", "서울시 성동구");
    %>
    <!--  현재 헤이지 session 에서 name application 에서 address지정.
    	 이뜻은 session 이 종료되면 name 은 없어지지만 addreess는 계속 유지된다.  -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>이름과 주소를 저장합니다.</h1>
   <a href=appTest2.jsp>두번째 웹 페이지로 이동.</a>
</body>
</html>