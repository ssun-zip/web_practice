<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
   request.setCharacterEncoding("utf-8");
%> 

<%!
  String msg = "아이디를 입력하지 않았습니다. 아이디를 입력해 주세요.";
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>결과창</title>
</head>
<body>
<%
// login2.jsp에 저장되어있는 userID 에 대한 정보를 받아온다. 
   String userID = request.getParameter("userID" );
   if(userID.length()==0){
%>
<!-- forward :  requestDispatcher 클래스를 대신해서 포워딩하는 방법 제공
	   포워드할 jsp page login2.jsp - 포워딩 값을 전달 할수 있음. -->
   <jsp:forward  page="login2.jsp" >
   <!-- String type만의 값을 전달할 수 있다 /  
		   <jsp:param>태그를 이용해서 포함할 JSP 페이지에 파라미터를 추가할 수 있다.
			<jsp:param>액션 태그는 <jsp:include>나 <jsp:forward>액션 태그의 자식 태그로 추가-->		
      <jsp:param name="msg" value="<%= msg %>" />
   </jsp:forward>

<%	
  }
%>
  <h1>환영합니다.   <%=userID %>님!!! </h1>
</body>
</html>
