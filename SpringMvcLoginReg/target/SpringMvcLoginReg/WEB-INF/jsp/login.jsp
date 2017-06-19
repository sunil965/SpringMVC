<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<div align="center">
		<h1>Login</h1>
		<form action="login" method="post">
			<table>
				<tr>
					<td>Email :</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Sign In"></td>
					
					<td><span></span><input type="reset" value="Reset"></td>
				</tr>
			</table>
			${msg }
		</form>
	</div>

</body>
</html>