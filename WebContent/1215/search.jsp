<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
 search.jsp + member.jsp  + MemberDAO.java + MemberVO.java
 search 에서 조회하고 싶은 이름을 받아 member을 통해 정보를 출력한다.
 membervo 는 정보를 담고 있는 getter setter
 memberDAO 는 search하기위해 데이터베이스와 연결하는 정보를 담고 있다.  -->
</head>
<body>
	<form method = "post" action = "member.jsp">
		이름 : <input type = "text" name = "name"> <br>
		<input type = "submit" value = "조회하기">
	</form>
</body>
</html>