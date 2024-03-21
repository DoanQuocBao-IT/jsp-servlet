<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Xoa Mon Hoc</title>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>   
    <h3>Delete Mon Hoc</h3>   
    <p style="color: red;">${errorString}</p>
    <a href="monhocList">Mon Hoc List</a> 
</body>
</html>