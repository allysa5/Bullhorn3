<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

<form action= "LoginServlet" method="post">
Email: <input type= "text" name="email" id="email"></input><br>
Password: <input type="password" name="password"></input><br>
<input type="hidden" name="action" value="login"></input>
<input type="submit" value="Log In"></input>
<input type="reset" value="Reset"></input>
</form>


</body>
</html>