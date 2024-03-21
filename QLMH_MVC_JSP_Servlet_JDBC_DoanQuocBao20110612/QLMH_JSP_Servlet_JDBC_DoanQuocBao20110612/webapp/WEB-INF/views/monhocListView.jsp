<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Danh sach mon hoc</title>
	<script type="text/javascript">
	function testConfirmDialog(maso_monhoc){
		var result = confirm("Ban chac chan muon xoa muon nay?");
		if(result){
			window.location.href="deleteMonHoc?maso_monhoc="+maso_monhoc
		}else{
			return false;
		}
	}
	</script>
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
    <h3>Danh sach mon hoc</h3>
    <p style="color: red;">${errorString}</p>
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>maso_monhoc</th>
          <th>ten_monhoc</th>
          <th>sotinchi</th>
          <th>Update</th>
          <th>Delete</th>
       </tr>
       <c:forEach items= "${monhocList}" var="monhoc" >
          <tr>
             <td>${monhoc.maso_monhoc}</td>
             <td>${monhoc.ten_monhoc}</td>
             <td>${monhoc.sotinchi}</td>
             <td>
                <a href="updateMonHoc?maso_monhoc=${monhoc.maso_monhoc}">Update</a>
             </td>
             <td>
                <a href="#" onclick="testConfirmDialog(${monhoc.maso_monhoc});">Delete</a>
             </td>
          </tr>
       </c:forEach>
    </table>
    <a href="createMonHoc" >Them Mon Hoc</a>
</body>
</html>