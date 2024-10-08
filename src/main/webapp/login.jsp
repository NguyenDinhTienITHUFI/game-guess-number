
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="en">
<head>
  <title>Đăng nhập</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  <div class="row mt-5">
    <div class="col-md-5 m-auto mt-5">
      <h3 class="text-center">Đăng Nhập</h3>
      <div class="p-4 border mt-4">
        <form >
            <div class="form-group">
              <label>Email</label>
              <input type="text" class="form-control" name="username" id="username">
            </div>
            <div class="form-group">
              <label>Mật khẩu</label>
              <input type="password" class="form-control" name="password" id="password">
            </div>
            <button type="submit" class="btn btn-primary btn-login">Đăng Nhập</button>
            <a href="http://localhost:8080/game/register" class="btn btn-success">Đăng ký</a>

          </form>
      </div>
      </div>
  </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="js/login.js"></script>
</body>
</html>
