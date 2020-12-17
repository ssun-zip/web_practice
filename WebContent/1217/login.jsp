<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false" %>
   <!--custom tag 이용하기 -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- contextPath가 변경되어도 소스 수정없이 적용하기 위해 사용 / 유지 보수 용이   -->
<c:set var = "contextPath" value = "${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "result.jsp">
		아이디 : <input type = "text" name = "userID" size = 20 /> <br>
		비밀번호 : <input type = "password" size = 20 /> <br> 
		<input type = "submit" value = "로그인">
		<input type = "reset" value = "다시입력">
	</form>
	<br><br>
	<%--
		<a href = "$(pageContext.request.contextPath}/memberForm.jsp">회원등록하기 </a>
	--%>
	<a href = "${contextPath}/test03/memberForm.jsp"> 회원등록하기</a>
	<!-- context path : context 설정을 server.xml 에서 분리함으로써 변경 후에도 톰캣을 재시작할 핗요가 없음.  -->
</body>
</html>