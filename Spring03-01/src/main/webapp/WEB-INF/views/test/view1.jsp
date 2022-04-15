<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view1</title>
</head>
<body>


<c:choose>  
	<c:when test="${num == 1}">
		안녕하세요 111
	</c:when> 
	<c:when test="${num == 2}">
		반갑습니다 222
	</c:when> 
	<c:otherwise>
	    333333
	</c:otherwise> 
</c:choose>  




</body>
</html>