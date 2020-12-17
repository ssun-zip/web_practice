<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*, sec1217.*" isELIgnored = "false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

	<jsp:useBean id = "membersList" class = "java.util.ArrayList"/>
	<jsp:useBean id = "membersMap" class = "java.util.HashMap"/>
<%
	// Map 에 데이터 생성 
	membersMap.put("id", "park2");
	membersMap.put("pwd", "4321");
	membersMap.put("name", "박지성");
	membersMap.put("email", "park2@test.com");
	// MemberBean통해서 정보저장한다. 
	MemberBean m1 = new MemberBean("son", "1234", "손흥민" , "son@test.com");
	MemberBean m2 = new MemberBean("ki", "1234" ,"기성룡", "ki@test.com");
	//저장된 내용을 arraylist에저장한다. 
	membersList.add(m1);
	membersList.add(m2);
	// map에 리스트에 저장된 있는 내용 저장 
	membersMap.put("membersList", membersList);
	

%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr align = "center">
			<td> ${membersMap.id} </td>
			<td> ${membersMap.pwd} </td>
			<td> ${membersMap.name} </td>
			<td> ${membersMap.email} </td>
		</tr>
		<!-- for loop을 통해 i 가 0-2 일경우의 리스트의 내용 불러오기  -->
		<c:forEach var="i" begin="0" end="2" step="1">
			<tr align = "center">
				<td> ${membersList[i].id} </td>
				<td> ${membersList[i].pwd} </td>
				<td> ${membersList[i].name} </td>
				<td> ${membersList[i].email} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>