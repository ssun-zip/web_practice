<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>       
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<%
  request.setCharacterEncoding("utf-8");
%>
<html><head><meta charset="UTF-8">
<title>여러 가지 문자열 함수 기능</title></head>
<body>
	<c:set var="title1" value="hello world!" />
	<c:set var="title2" value="쇼핑몰 중심 JSP입니다!" />
	<c:set  var="str1" value="중심" />
	<h2>여러 가지 문자열 함수 기능</h2>
	title1="hello world"<br>
	title2="쇼핑몰 중심 JSP 입니다.!"<br>
	str1="중심"<br><br>
	<!-- 문자열 title1 저체 길이를 출력 -->
	fn:length(title1)=${fn:length(title1) } <br>
	<!-- 대문자 소문자로 변환   -->
	fn:toUpperCase(title1)=${fn:toUpperCase(title1)}<br>
	fn:toLowerCase(title1)=${fn:toLowerCase(title1)}<br><br>
	
	<!-- 문자열 manipulate하여 반환 
		substring - index : 1,3,6 반환
		trim : 앞뒤 공백 제거하여 반환
		replace : 빈칸의 자리를 /로 변환하여 반환 -->
	fn:substring(title1,3,6)=${fn:substring(title1,3,6)}<br>
	fn:trim(title1)=${fn:trim(title1)}<br>
	fn:replace(title1," ","/")=${fn:replace(title1," ","/")}<br><br>
	
	<!-- indexOf : str1 문자열의 자리 위치 반환 
		contains : 문자열1 에 str1이 포함되는지를 boolean 형태로 반환  -->
	fn:indexOf(title2,str1)=${fn:indexOf(title2,str1) }<br>
	fn:contains(title1,str1)=${fn:contains(title1,str1) }<br>
	fn:contains(title2,str1)=${fn:contains(title2,str1) }<br>
</body></html>
