<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<!-- ajax로 json 데이터를 가져온 후 서블릿에서 각각의 배열에 대해 지정한 배열 이름으로 회원 정보와 
	도서 정보를 가져와 출력한다  -->
  <title>JSON 테스트</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script>
     $(function() {
        $("#checkJson").click(function() {
    	  $.ajax({
            type:"post",
            async:false, 
            url:"${contextPath}/json3",
            success:function (data,textStatus){
               var jsonInfo = JSON.parse(data);
             var memberInfo ="회원 정보<br>";
	     memberInfo += "=======<br>";
	     // 배열 이름 members에 담긴 정보 출력 
	     for(var i in jsonInfo.members){
	       memberInfo += "이름: " + jsonInfo.members[i].name+"<br>";
	       memberInfo += "나이: " + jsonInfo.members[i].age+"<br>";
	       memberInfo += "성별: " + jsonInfo.members[i].gender+"<br>";
	       memberInfo += "별명: " + jsonInfo.members[i].nickname+"<br><br><br>";
	     }
	     // 배열이름 books에 저장되있는 도서 정보를 출력합니다. 	
	     var booksInfo = "<br><br><br>도서 정보<br>";
	     booksInfo += "===========<br>";
	     for(var i in jsonInfo.books) {
	        booksInfo += "제목: " + jsonInfo.books[i].title+"<br>";
	        booksInfo += "저자: " + jsonInfo.books[i].writer+"<br>";
	        booksInfo += "가격: " + jsonInfo.books[i].price+"원 <br>";
	        booksInfo += "장르: " + jsonInfo.books[i].genre+"<br>";
	        // 이미지 URL 을 구해 <img src> 태그안에 설정해준다. 
            imageURL = jsonInfo.books[i].image;
            booksInfo += "<img src="+imageURL+" />"+"<br><br><br>";
	     }
	     $("#output").html(memberInfo+"<br>"+booksInfo);
	   },
	   error:function(data,textStatus){
	      alert("에러가 발생했습니다.");ㅣ
	   }
	  });  //end ajax	
        });
     });
</script>
</head>
<body>
   <a id="checkJson" style="cursor:pointer">데이터 수신하기</a><br><br>
    <div id="output"></div>
</body>
</html>