<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>       
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<!-- 파일 업로드를 위해 WEB-INF > lib > commons-fileupload/ commons-io 넣기 
	서블릿에 요청해 파일을 업로드합니다. upload.do 
	 enctype- 파일 업로드 시 반드시 encType = multipart/form-data로 설정  -->
	<form action = "${contextPath}/upload.do" method = "post" enctype = "multipart/form-data">
		파일1: <input type = "file" name = "file1"><br>
		파일2: <input type = "file" name = "file2"><br>
		파라미1: <input type = "text" name = "parameter1"><br>
		파라미2: <input type = "text" name = "parameter2"><br>
		파라미3: <input type = "text" name = "parameter3"><br>
		<input type = "submit" value = "업로드" >
		
	</form>
</body>
</html>