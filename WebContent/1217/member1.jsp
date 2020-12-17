<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false"%>
    <!-- jstl: custom tag library 이용  -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>
<c:set var = "id" value = "hong" scope = "page" />
<c:set var = "pwd" value = "1234" scope = "page" />
<c:set var = "name" value = "${'홍길동'}" scope = "page" />
<c:set var = "age" value = "${22}" scope = "page" />
<c:set var = "height" value = "${177}" scope = "page" />
<!--  value속성은 지정하지 않고도 사용이 가능한 예입니다.  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 테이블 생성  -->
	<table align = "center" border = 1>
		<tr align = "center" bgcolor = "lightgreen">
			<td width = "7%"> <b> 아이디</b> </td>
			<td width = "7%"> <b> password</b> </td>
			<td width = "7%"> <b> name</b> </td>
			<td width = "7%"> <b> age</b> </td>
			<td width = "7%"> <b> height</b> </td>
		</tr>
		<!-- c:set의 value들을 받아오는 과정  -->
		<tr align = "center">
			<td> ${id} </td>
			<td> ${pwd} </td>
			<td> ${name} </td>
			<td> ${age} </td>
			<td> ${height} </td>
		</tr>
	</table>
</body>
</html>