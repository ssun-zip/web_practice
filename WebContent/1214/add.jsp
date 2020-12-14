<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>  <!-- errorPage = "error.jsp" -->
<!-- error.jsp 하면 예외처리가 error로 가고 없에게 되고 xml 에다가 만들면 해당페이지 404, 500으로 간다.  -->
    <%
 // add/html 파일에서 num 을 받아와 1부터의 합을 더한다. 

    	int num = Integer.parseInt(request.getParameter("num"));
    	int sum = 0;
    	for(int i  = 0; i <= num; i++){
    		sum = sum + i;
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 합계 구하기 </h3>
	<h1> 1부터 <%= num  %> 까지의 합은 <%= sum %> 입니다. </h1>
</body>
</html>