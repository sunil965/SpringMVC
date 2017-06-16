<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Edit User Details</h1>
		<form action="editsave" method="post">
			<table>
				<c:forEach items="${users}" var="list">
				<tr>
					  <td><input type="hidden" name="id" value="${list.id }"></td> 
				</tr>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" value="${list.name }"></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="email" name="email" value="${list.email }"></td>
				</tr>
				<tr>
					<td>Contact :</td>
					<td><input type="number" name="contact" value="${list.contact }"></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" value="${list.password }"></td>
				</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>