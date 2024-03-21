<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tao Mon Hoc </title>
	<script type="text/javascript">
	function validateForm(){
		var x=document.forms["createSVForm"]["ten_monhoc"].value;
		var y=document.forms["createSVForm"]["sotinchi"].value;
		if(x==""){
			alert("Vui long nhap ten mon hoc");
		}
		if(y==""){
			alert("Vui long nhap dia chi");
		}else
			return true;
	}
	</script>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>      
      <h3>Tao Mon Hoc</h3>      
      <p style="color: red;">${errorString}</p>      
      <form method="POST" action="${pageContext.request.contextPath}/createMonHoc"
      name="createSVForm" onsubmit="return validateForm()">
         <table border="0">
            <tr>
               <td>maso_monhoc</td>
               <td><input type="text" name="maso_monhoc" value="${monhoc.maso_monhoc}" /></td>
            </tr>
            <tr>
               <td>ten_monhoc</td>
               <td><input type="text" name="ten_monhoc" value="${monhoc.ten_monhoc}" /></td>
            </tr>
            <tr>
               <td>sotinchi</td>
               <td><input type="text" name="sotinchi" value="${monhoc.sotinchi}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="monhocList">Cancel</a>
               </td>
            </tr>
         </table>
      </form>  
</body>
</html>