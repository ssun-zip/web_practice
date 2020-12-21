<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html><head><title>JSON ajax 연습</title>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
 <script>
 /* 회원 정보를 JSON 객체로 만들어 매개변수 이름 jsonInfo 로 ajax 이용해 서블릿 전송  
 	$.ajax({ 
 		type: "GET", 
 		url: url, 
 		data: data, 
 		success: success, 
 		dataType: dataType });
 */
    $(function() {
        $("#checkJson").click(function() {
        	// 전송할 회원 정보를 JSON 형식으로 생성 
    	   var _jsonInfo ='{"name":"박지성","age":"25","gender":"남자","nickname":"날센돌이"}';
    	   // 비동기식 ajax 이용하여 HTTP 요청을 전송함 
    	   $.ajax({
             type:"post", // HTTP 요청 메소드 (get/post)
             async:false, 
             url:"${contextPath}/json", // 요청을 보낼 서버의 주소 
             // 매개변수 이름 jsonInfo 로 json 데이터를 ajax로 전송 
             // HTTP 요청과 함께 서버로 보낼 데이텅 
             data : {jsonInfo: _jsonInfo},
             // 성공시 실행되는 callback 함수 
             success:function (data,textStatus){
	     },
	     error:function(data,textStatus){
	        alert("에러가 발생했습니다.");ㅣ
	     },
	     complete:function(data,textStatus){
	     }
	   });  //end ajax	

       });
    });
 </script></head>
<body>
   <a id="checkJson" style="cursor:pointer">전송</a><br><br>
    <div id="output"></div>
</body></html>
