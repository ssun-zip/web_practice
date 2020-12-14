<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	request.setCharacterEncoding("utf-8");
    	int score = Integer.parseInt(request.getParameter("score"));
    	//html form 에서 만든 score받아오기 
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 안녕하세요. 스터디 중심 JSP 시작입니다 !!! </h1> <br>
	<%@ include file = "duke_image.jsp" %> <br>
	<h3> 안녕하세요. 스터디 중심 JSP 끝 부분입니다. </h3>
	<h3> 시험점수 <%= score %> 점 </h3>
	<%
		if(score >= 90){
	%>
	 <h3> A 학점 입니다. </h3>
	 <%
		} else if(score >= 80 && score < 90){
	%>
	 <h3> B 학점 입니다. </h3>
	 <%
		} else if(score >= 70 && score < 80){
	%>
	 <h3> C 학점 입니다. </h3>
	 <%
		} else if(score >= 60 && score < 70){
	%>
	 <h3> D 학점 입니다. </h3>
	 <%
		} else {
	 %>
	 <h3> F 학점 입니다. </h3>
	 <%
		}
	 %>
	 <br> <a href = "scoreTest.html"> 시험점수 입력</a>
</body>
</html>