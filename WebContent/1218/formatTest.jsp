<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored = "false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import = "java.util.Date" %>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> format number 태그를 이용한 숫자 포매팅 예제 </h2>
	<c:set var = "price" value = "100000000" /> 
	<fmt:formatNumber value = "${price}" type = "number" var = "priceNumber" />
	통화로 표현 시 :
<!-- 	  숫자를 원화로 표시
    groupingUsed="true" -> 세자리 숫자마다 콤마로 표시. 설정하지 않으면 기본값이 true. false 이면 콤마가가 표시되지 않음. -->
	<fmt:formatNumber type = "currency" currencySymbol = "w" value = "${price}" groupingUsed = "true" /> <br>
	퍼센트로 표현할 시 :
	<fmt:formatNumber value = "${price}" type = "percent" groupingUsed = "false"/>
<!-- 	  fmt:formatNumber 태그에서 var 속성에 정한 변수이름으로 표현 언어에서 출력함. -->	
	일반 숫자로 표현 시 : ${priceNumber} <br>
	
	<h2> format Date 예제 </h2>
	<c:set var  = "now" value = "<%=new Date() %>" />
	<fmt:formatDate value = "${now}" type = "date" dateStyle = "full" /> <br>
	<fmt:formatDate value = "${now}" type = "date" dateStyle = "short" /> <br>
	<fmt:formatDate value = "${now}" type = "time"/> <br>
	<fmt:formatDate value = "${now}" type = "both" dateStyle = "full" timeStyle = "full"/> <br>
<!-- 	    // fmt:formatDate 태그의 pattern 속성에 출력한 날짜 포맷을 지정함.-->	
	<fmt:formatDate value = "${now}" pattern = "YYYY-MM-DD :hh:mm:ss" /> <br>
	<br><br>
	한국 현재 시간 :
	<fmt:formatDate value = "${now}" type = "both" dateStyle = "full" timeStyle = "full" />
	<br><br> <fmt:timeZone value = "America/New York" > <!-- 뉴욕 시간대로 변경  -->
	뉴욕 현재 시간 : 
	<fmt:formatDate value = "${now}" type = "both" dateStyle = "full" timeStyle = "full" />
	<br> </fmt:timeZone>
</body>
</html>