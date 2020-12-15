<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
request.setCharacterEncoding("utf-8");
%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include1.jsp</title>
</head>
<body>
  안녕하세요. 쇼핑몰 중심 JSP 시작입니다!!!
<br>
<!--  	
jsp:include><jsp:include>
		JavaServerPage(JSP)에서는 다른 내용을 JSP 페이지의 중간에 포함시키기 위해서
/jsp:include></jsp:include>

두가지 방법을 제공합니다.

그 첫번째 방법이 include 지시어이고, 두번째는 JSP 액션 태그중에서 <jsp:include> 태그를 사용 

 => include 지시어는 다른 JSP의 소스 코드를 해당 JSP에 그대 포함시킵니다.
 
include는 주로 조각난 코드를 삽입을 하고자 할때 사용되고,
<★jsp:include> 액션 태그는 페이지를 모듈화할때 사용됩니다.
즉 템플릿 페이지를 작성할때 사용됩니다.

 - flush 속성
 포함될 페이지로 이동할 때 현재 페이지가 지금까지 출력 버퍼에 저장할
결과를 어떻게 처리할 것인가를 결정하는 것으로, flush 속성의 값을 'true'로
지정하면 포함할 페이지의 내용을 삽입하기 이전에 현재 페이지가 지금까지
버퍼에 저장한 내용을 출력하게 됩니다.

<★jsp:include>태그에서는 flush 속성의 값을 'false'로 지정하는 것이 일반적입니다.
만일 flush 속성의 값을 'true'로 지정하게 되면 일단 출력 버퍼의 내용을 웹
브라우저에 전송하게 되는데 이때 헤더 정보도 같이 전송됩니다. 일단 헤더
정보가 웹 브라우저에 전송이 되고 나면 헤더 정보를 추가해도 결과가 반영되지 않습니다.

그래서 <★jsp:include> 태그에서는 flush 속성의 값을 'false'로 지정합니다. 

 

-->
<jsp:include  page="duke_image.jsp"  flush="true" >
   <jsp:param name= "name"  value="듀크" />
   <jsp:param name="imgName"  value="duke.png" />
</jsp:include>
<br>
  안녕하세요. 쇼핑몰 중심 JSP 끝 부분입니다.!!!
</body>
</html>
