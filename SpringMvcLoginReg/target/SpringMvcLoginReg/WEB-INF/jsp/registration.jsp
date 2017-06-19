<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registration</title>

<style type="text/css">
#color {
	color: red;
}
</style>
</head>
<body>
	<div align="center">
		<h1>Add New User</h1>
		<form:form action="register" method="post" modelAttribute="registrationModel">
			<table>
				<!-- <tr>
					            <td><input type="hidden" name="id"></td>
				</tr> -->
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
					<td id="color"><form:errors path="name" /></td>

				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="email" /><br> <span
						style="color: red">${msg}</span></td>
					<td id="color"><form:errors path="email" /></td>

				</tr>
				<tr>
					<td>Contact :</td>
					<td><form:input path="contact"/></td>
					<td id="color"><form:errors path="contact"/></td>

				</tr>
				<tr>
					<td>Password :</td>
					<td><form:input path="password" /></td>
					<td id="color"><form:errors path="password" /></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
			<a href="users">Get Registered Users List</a><br>
			<p>
				<span style="color: green">${msg2}</span>
			</p>

		</form:form>
	</div>
</body>
</html>