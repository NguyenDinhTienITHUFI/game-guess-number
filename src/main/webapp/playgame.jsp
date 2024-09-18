<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Game đoán số</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }
    .game-container {
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    input[type="number"], input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 16px;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: white;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="game-container">
        <h1>Đoán số</h1>
		<% Integer id = (Integer) request.getAttribute("userId"); %>
        <% if (id != null) { %>
            <p><strong>User ID: <%= id %></strong></p>
        <% } %>


        <form method="post">
            <input type="number" name="sodudoan" placeholder="Nhập số bạn dự đoán" required>
            <input type="submit" value="Submit">
        </form>

        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p><strong><%= message %></strong></p>
        <% } %>

        <% Integer attempts = (Integer) request.getAttribute("attempts"); %>
        <% if (attempts != null) { %>
            <p>Số lần đã dự đoán: <%= attempts %></p>
        <% } %>

        <% Boolean reset = (Boolean) session.getAttribute("reset"); %>
        <% if (reset != null && reset) { %>
            <p><a href="/game">Chơi lại</a></p>
        <% } %>
    </div>
</body>
</html>
