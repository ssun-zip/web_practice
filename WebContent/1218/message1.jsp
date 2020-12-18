<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--<fmt:setLocale value = "en_US" />--%>
	<!-- format:setLocale :  Locale을 지정 
	value : 언어코드_국가코드 형식으로 지정하되 언어코드는 필수이고, 국가코드는 추가지정할 수 있다. 
			사이에 구분은 바(-) 또는 언더바(_)로 구분한다.
	scope : 영역을 설정한다. 기본값은 page이다
-->

	 <fmt:setLocale value = "ko_KR" /> 
	<h1> 회원 정보 <br> <br> 
	<!-- resource -> member.propertoes  -->
		<fmt:bundle basename = "resource.member">
			이름 : <fmt:message key = "mem.name" /> <br>
			주소 : <fmt:message key = "mem.address" /> <br>
			직업 : <fmt:message key = "mem.job" /> <br>
		</fmt:bundle>
	
	</h1>
</body>
</html>
<%--

포매팅 태그 라이버리
: JSP 페이지에서 가격, 날짜, 문자열을 원하는 형식으로 표시 할 수 있음. 
<fmt:timeZone>
<fmt:setTimeZone>
둘 다 지정한 국가의 시간을 지정하는 태그입니다.
<fmt:timeZone> 태그의 경우 태그를 열고 닫는 영역 안에서만 적용된다는 차이점 있음.
<fmt:formatNumber> 표시할 숫자의 형식을 지정
<fmt:formatDate> 지정한 형식의 날짜를 표시 

--%>