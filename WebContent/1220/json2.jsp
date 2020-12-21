<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSON 테스트</title>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <!-- 정수 자료형을 배열로 저장한 후 화면 출력  -->
<script>
      $(function() {
          $("#checkJson").click(function() {
        	  // 정수형 데이터 배열을 가진 이름이 age 선언 
             var jsonStr = '{"age": [22, 33, 44]}';  
             //parse() 이용하여 배열으로 변환 
             var jsonInfo = JSON.parse(jsonStr);
             var output ="회원 나이<br>";
             output += "=======<br>";
        	// 배열 요소 (나이) 차례대로 출력 
             for(var i in jsonInfo.age) {
                output += jsonInfo.age[i]+"<br>";
             }
             $("#output").html(output);
        });
     });
</script>
</head>
<body>
    <a id="checkJson" style="cursor:pointer">출력</a><br><br>
    <div id="output"></div>
</body>
</html>
