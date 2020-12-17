<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align = "center" border = "1">
		<tr align = "center" bgcolor = "lightgreen">
			<td width = "7%"> <b> 아이디</b> </td>
			<td width = "7%"> <b> password</b> </td>
			<td width = "7%"> <b> name</b> </td>
			<td width = "7%"> <b> age</b> </td>
			<td width = "7%"> <b> height</b> </td>
		</tr>
		<!-- 이름 정보가 존재하지 않을 경우  -->
		<!-- <c:choose>는 자바의 Switch문과 비슷한 역할
			<c:when>: case와 같은 역할을 하는것은 <c:choose>안의 <c:when>태그
			default문 같은 역할을 사용하고 싶으면 <c:shoose>태그 안에 <c:otherwise>태그를 사용
		 -->
		<!-- <c:choose> 태그 내부의 <c:when> 만족한 조건을 찾지못하면 <c:otherwise> 실행 -->
		<c:choose>
			 <c:when test = "${name == null}">
			<c:when test = "${empty name}">
				<tr align = "center">
					<td colspan =5> 이름을 입력하세요 </td>
				</tr>
			</c:when>
		
			<!--  c:set의 value들을 받아오는 과정 -->
			<c:otherwise>
				<tr align = "center">
					<td> ${id} </td>
					<td> ${pwd} </td>
					<td> ${name} </td>
					<td> ${age} </td>
					<td> ${height} </td>
				</tr>
         </c:otherwise>
      </c:choose>
      </table>
   </body>
</html> --%>