<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cap nhat Mon Hoc</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
      <h3>Update Mon Hoc</h3>
      <p style="color: red;">${errorString}</p>
      <c:if test="${not empty monhoc}">
         <form method="POST" action="${pageContext.request.contextPath}/updateMonHoc">
            <input type="hidden" name="maso_monhoc" value="${monhoc.maso_monhoc}" />
            <table border="0">
               <tr>
                  <td>maso_monhoc</td>
                  <td style="color:red;">${monhoc.maso_monhoc}</td>
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
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/monhocList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
</body>
</html>