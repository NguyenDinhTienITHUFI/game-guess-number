$(document).ready(function() {
    $('.btn-login').click(function(e) {
        e.preventDefault(); 
        
        var name = $("#username").val();
        var pass = $("#password").val();
        
        $.ajax({
            method: "POST",
            url: "http://localhost:8080/game/api/user/login",
            data: { username: name, password: pass },
            dataType: "json" 
        })
        .done(function(data) {
           
            if (data.isSuccess) {
                alert("Đăng nhập thành công");
                window.location.href = "http://localhost:8080/game/index"; 
            } else {
                alert("Đăng nhập thất bại: " + data.data); 
            }
        })
        .fail(function() {
          
            alert("Lỗi kết nối đến máy chủ.");
        });
    });
	$('.btn-reg').click(function(e) {
	        e.preventDefault(); 
	        
	        var name = $("#username").val();
	        var pass = $("#password").val();
			var hoten=$("#hoten").val();
			var age=$("#age").val();
	        
	        $.ajax({
	            method: "POST",
	            url: "http://localhost:8080/game/api/user/reg",
	            data: { username: name, password: pass ,hoten:hoten,age:age},
	            dataType: "json" 
	        })
	        .done(function(data) {
	            
	            if (data.isSuccess) {
	                alert("Đăng ký thành công");
	                window.location.href = "http://localhost:8080/game/login"; 
	            } else {
	                alert("Đăng ký thất bại: " + data.data); 
	            }
	        })
	        .fail(function() {
	            
	            alert("Lỗi kết nối đến máy chủ.");
	        });
	    })
});
