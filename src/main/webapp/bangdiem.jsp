<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Trang Điều Khiển</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }

        button {
            padding: 10px 20px;
            margin: 10px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            background-color: #4CAF50;
            color: white;
            border-radius: 5px;
        }

        button:hover {
            background-color: #45a049;
        }

        .logout-button {
            background-color: #f44336;
        }

        .logout-button:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>

    <h1>Bảng điểm vinh danh</h1>
    <table class="table">
    	<thead>
    		<tr>
    			<td>Họ tên</td>
    			<td>Số điểm đạt được</td>
    			<td>Ngày đạt</td>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${dsDiem}" var="itemData">
				<tr>
					<td>${itemData.hoten}</td>
					<td>${itemData.diem}</td>
					<td>${itemData.created_time}</td>
				</tr>


			</c:forEach>
    	</tbody>
    </table>

</body>
</html>
