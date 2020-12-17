<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="java.util.*"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//list -> hello, world, 안녕하세요 
  List dataList=new ArrayList();
  dataList.add("hello");
  dataList.add("world");
  dataList.add("안녕하세요!!");
%>
<c:set  var="list"  value="<%=dataList  %>" />
<html>
<head>
<meta charset=”UTF-8">
<title>반복문 실습</title>
</head>
<body>
<!-- for(int i = 0; i < 10; i++ ) {
		i = i + "___ 반복횟수 : " + i;
		// &nbsp; ->공백을 나타내주는 것 
		// loop.count = 반복횟수 = i
} -->
   <c:forEach  var="i" begin="1" end="10" step="1"  varStatus="loop">
    i=  ${i}   &nbsp;&nbsp;&nbsp;  반복횟수: ${loop.count} <br>
   </c:forEach>
 <br>
<!-- for(int i = 0; i < 10; i+=2 ) {
		" 5 * i " = 5 * i
		//5 * ${i} - 글씨 print 
} -->
   <c:forEach  var="i" begin="1" end="10" step="2" >
        5 * ${i} = ${5*i}<br>
   </c:forEach>
<br>
<!-- for(int i = 0; i < list.size; i++ ) {
		String data = list[i];
		S.O.pln(data);
} -->
   <c:forEach  var="data" items="${list}" >
       ${data } <br> 
   </c:forEach>
<br>
<!--  forToken : 문자열을 분리자를 사용해서 분리해서 출력 
	List fruits = {사과, 파인애플, 바나나, 망고, 귤 };
	for(int i = 0; i < fruits.size; i++) {
		String token = fruits[i];
	}
 -->
<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤"  />
<c:forTokens  var="token" items="${fruits}" delims="," >
    ${token} <br> 
</c:forTokens>
</body>
</html>
