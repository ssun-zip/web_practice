<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
	    String name = request.getParameter("name");
	    String age = request.getParameter("age");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if(name != null || name.length() != 0) {
	%>
	<h1> <%= name %>, <%= age %></h1>
	<h3>  %= name %></h3>
	<% } else { %>
	<h1> 이름을 입력하세요 </h1>
	<%
	}
	%>
	
	<%
		if(name != null || name.length() !=0) {
	%>
		<h2> <% out.println(name + ", " + age); %></h2> <br>
		<h3> out.println</h3>
	<% } else { %>
		<h1> 이름을 입력하세요 </h1>
	<% } %>
</body>
</html>