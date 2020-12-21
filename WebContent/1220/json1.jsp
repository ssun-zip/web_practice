<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(function() {
        $("#checkJson").click(function() {
        // 배열을 대괄호 [] 를 이용하여 나타낸다. - 기본 자료형이거나 배열 객체이고 콤마로 구별한다.
        //JSON 배열의 예시 
        var jsonStr  = '{"name": ["홍길동", "이순신", "임꺽정"] }';  
        // JSON 기능인 parse() 이용하여 JSON 자료형으로 변환하여 가져온다. 
        var jsonInfo = JSON.parse(jsonStr);
        var output ="회원 이름<br>";
        output += "=======<br>";
        // 배열의 이름을 저장하는 JSON 배열을 name 으로 선언 
        for(var i in jsonInfo.name) {
            output += jsonInfo.name[i]+"<br>";
        }
        // 제이쿼리의 JSON 기능인 parse이용해 JSON 자료형을 가져온다. 
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
