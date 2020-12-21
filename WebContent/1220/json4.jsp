<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <!-- json 배열 요소에 json 객체를 저장한 후 다시 배열에 접근하여 json 객체의 속성값
  출력  -->
<script>
    $(function() {
        $("#checkJson").click(function() {
        	// name - value 배열로 정보 저장 
        var jsonStr  = '{"name": ["홍길동", "이순신", "임꺽정"] }';          
        var jsonInfo = JSON.parse(jsonStr);
        var output ="회원 이름<br>";
        output += "=======<br>";
        // name 에 담긴 json형태의 데이터를 불러온다. 
        for(var i in jsonInfo.name) {
            output += jsonInfo.name[i]+"<br>";
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
