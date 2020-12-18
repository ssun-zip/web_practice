<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*, sec1218.*"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>       
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align = "center" border = "1"  align = "center">
		<tr align = "center" bgcolor = "lightgreen">
			<td width = "7%"> <b> 아이디 </b>  </td>
			<td width = "7%"> <b> password </b>  </td>
			<td width = "7%"> <b> name </b>  </td>
			<td width = "7%"> <b> email </b>  </td>
			<td width = "7%"> <b> Join Date </b>  </td>
		</tr>
		<c:choose>
		<%-- ArrayList list = request.getAttribute("membersList");  --%>
			<c:when test = "${membersList == null }">
				<tr>
					<td colspan = 5> <b> 등록된 회원이 없습니다. </b> </td>
				</tr>
			</c:when>
			<c:when test = "${membersList != null}">
			<%--for(int i = 0; i < membersList; i++) { .. }   --%>
				<c:forEach var = "mem" items = "${membersList}">
					<tr align = "center" >
						<td> ${mem.id} </td>
						<td> ${mem.pwd} </td>
						<td> ${mem.name} </td>
						<td> ${mem.email} </td>
						<td> ${mem.joinDate} </td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>
</html>