<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// include1, include2 에서 이름과 imgName = file의 이름을 받아와 저장한다. 
   request.setCharacterEncoding("utf-8");
   String name = request.getParameter("name" ) ;
   String imgName = request.getParameter("imgName" ) ;
%>
<!DOCTYPE html>
<html><head><meta  charset="UTF-8">
<style>
	img {
		width: 100px;
	}
</style>
<title>듀크이미지</title></head>
<body>
<br><br>
  <h1>이름은 <%= name%>입니다. </h1><br><br>
  <img src="image/<%=imgName %>"  />
</body></html>
