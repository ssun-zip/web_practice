<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html><head><meta charset=UTF-8">
<title>자바 빈 프로퍼티 값 얻고 변경(getProperty, setProperty 액션 태그)</title>
</head>
<body>
<!-- useBean 액션태그로 생성한 자바빈 객체에 대해서 프로퍼티(필드)에 값을 설정하는 역할 -->
	<jsp:useBean id="member" class="sec1215.MemberBean"/>
	<hr>
	◎ 자바 빈 객체 생성 후 저장된 정보 출력하기 <br><br>
	<!-- getProperty 액션태그는 자바빈 파일의 getter 메서드를 사용하기
		저장된 데이터의 값을 읽어올 때 사용 -->
	이름 : <jsp:getProperty name="member" property="name" /> <br>
	아이디 : <jsp:getProperty name="member" property="userid" />
	<hr>
	◎ 정보 변경한 후 변경된 정보 출력하기 <br><br>
	<!-- setter 메서드를 사용하기 위해, 즉 데이터의 값을 설정할 때 사용된다. -->
	<jsp:setProperty name="member" property="name" value="박변경이"/>
	<jsp:setProperty name="member" property="userid" value="pinkblue"/>
	이름 : <jsp:getProperty name="member" property="name" /> <br>
	아이디 : <jsp:getProperty name="member" property="userid" />
</body></html>