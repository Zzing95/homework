<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册账号</title>
</head>
<body>

	<h1>添加用户页面</h1>
		<form action="UsersServlet" method="post">
		<input type="hidden" name="flag" value="addUsers">
		<input type="hidden" name="user_id">
		 姓名<input type="text" name="user_name"><br>
		密码<input type="password" name="password">	<br>	
		类型<input type="text" name="type"><br>
		
		<input type="submit" value="提交">
		</form>
</body>
</html>