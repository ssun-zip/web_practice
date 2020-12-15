<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html><head><meta charset=UTF-8">
<title>자바 빈 객체 생성하기(useBean 액션 태그)</title></head>
<body>
<!-- javabean import from sec1215 의 MemberBean.java file  -->
<jsp:useBean id="member" class="sec1215.MemberBean"/>
<!-- jsp:useBean id="빈 이름" class="자바빈 파일의 패키지.클래스명" scope="유효범위" />  -->

	◎ 자바 빈 객체 생성 후 저장된 정보 출력하기 <br><br>
	<!-- 정해져있는 name, id출력하기  -->
	이름 : <%= member.getName() %> <br>
	아이디 : <%= member.getUserid() %>
	<hr>
	◎ 정보 변경한 후 변경된 정보 출력하기 <br><br>
	<% //name, Userid 생성하기 
	member.setName("박샘이");
	member.setUserid("pink");
	%>
	<!-- 위에서 생성해준 name, id 출력해주기  -->
	이름 : <%= member.getName() %> <br>
	아이디 : <%= member.getUserid() %>
</body></html>