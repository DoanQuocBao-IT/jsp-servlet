<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Danh sách môn học</title>
<script type="text/javascript">
        var currentIndex = 0;
        var pageSize = 11;
        var maxIndex = 0;

        function showNextRecords() {
            var rows = document.querySelectorAll("#monhocTable tbody tr");
            var i;

            // Ẩn tất cả các bản ghi hiện tại
            for (i = 0; i < rows.length; i++) {
                rows[i].style.display = "none";
            }

            // Hiển thị 5 bản ghi tiếp theo
            currentIndex += pageSize;
            for (i = currentIndex; i < currentIndex + pageSize && i < rows.length; i++) {
                rows[i].style.display = "";
            }
            updateNavigationButtons();
        }

        function showPreviousRecords() {
            var rows = document.querySelectorAll("#monhocTable tbody tr");
            var i;

            // Ẩn tất cả các bản ghi hiện tại
            for (i = 0; i < rows.length; i++) {
                rows[i].style.display = "none";
            }

            // Hiển thị 5 bản ghi trước đó
            currentIndex -= pageSize;
            for (i = currentIndex; i < currentIndex + pageSize && i < rows.length; i++) {
                rows[i].style.display = "";
            }
            updateNavigationButtons();
        }

        function showFirstPage() {
            var rows = document.querySelectorAll("#monhocTable tbody tr");
            var i;

            // Ẩn tất cả các bản ghi hiện tại
            for (i = 0; i < rows.length; i++) {
                rows[i].style.display = "none";
            }

            // Hiển thị trang đầu tiên
            currentIndex = 0;
            for (i = currentIndex; i < currentIndex + pageSize && i < rows.length; i++) {
                rows[i].style.display = "";
            }
            updateNavigationButtons();
        }

        function showLastPage() {
            var rows = document.querySelectorAll("#monhocTable tbody tr");
            var i;

            // Ẩn tất cả các bản ghi hiện tại
            for (i = 0; i < rows.length; i++) {
                rows[i].style.display = "none";
            }

            // Hiển thị trang cuối cùng
            currentIndex = maxIndex;
            for (i = currentIndex; i < rows.length; i++) {
                rows[i].style.display = "";
            }
            updateNavigationButtons();
        }

        // Hàm cập nhật trạng thái của các nút điều hướng
        function updateNavigationButtons() {
		    var firstButton = document.querySelector("#firstButton");
		    var previousButton = document.querySelector("#previousButton");
		    var nextButton = document.querySelector("#nextButton");
		    var lastButton = document.querySelector("#lastButton");
		
		    if (currentIndex === 0) {
		        firstButton.disabled = true;
		        previousButton.disabled = true;
		    } else {
		        firstButton.disabled = false;
		        previousButton.disabled = false;
		    }
		
		    if (currentIndex >= maxIndex || pageSize == 12) {
		        nextButton.disabled = true;
		        lastButton.disabled = true;
		    } else {
		        nextButton.disabled = false;
		        lastButton.disabled = false;
		    }
		}

        // Hàm khởi tạo: Ẩn tất cả các bản ghi ngoại trừ 5 bản ghi đầu tiên
        window.onload = function() {
            var rows = document.querySelectorAll("#monhocTable tbody tr");
            var i;
            for (i = pageSize; i < rows.length; i++) {
                rows[i].style.display = "none";
            }
            maxIndex = rows.length - rows.length % pageSize;
            updateNavigationButtons();
        };
    </script>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	<h3>Danh sách môn học</h3>
	<p style="color: red;">${errorString}</p>
	<table border="1" cellpadding="5" cellspacing="1" id="monhocTable">
		<thead>
			<tr>
				<th>maso_monhoc</th>
				<th>ten_monhoc</th>
				<th>sotinchi</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${monhocList}" var="monhoc">
				<tr>
					<td>${monhoc.maso_monhoc}</td>
					<td>${monhoc.ten_monhoc}</td>
					<td>${monhoc.sotinchi}</td>
					<td><a href="updateMonHoc?maso_monhoc=${monhoc.maso_monhoc}">Update</a>
					</td>
					<td><a href="#"
						onclick="testConfirmDialog(${monhoc.maso_monhoc});">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<button id="firstButton" onclick="showFirstPage()">First</button>
		<button id="previousButton" onclick="showPreviousRecords()">Previous</button>
		<button id="nextButton" onclick="showNextRecords()">Next</button>
		<button id="lastButton" onclick="showLastPage()">Last</button>
	</div>
	<a href="createMonHoc">Thêm Môn Học</a>
</body>
</html>
