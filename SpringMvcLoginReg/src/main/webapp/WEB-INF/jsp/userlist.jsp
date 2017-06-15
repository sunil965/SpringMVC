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
		<h2>Registered Users List</h2>
		<c:if test="${!empty users }">
			<table  border="2px solid black">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Contact</th>
					<th>Email</th>
					<th>Password</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${users}" var="list">
					<tr>
						<td><c:out value="${list.id }"></c:out></td>
						<td><c:out value="${list.name }"></c:out></td>
						<td><c:out value="${list.contact }"></c:out></td>
						<td><c:out value="${list.email }"></c:out></td>
						<td><c:out value="${list.password }"></c:out></td>
						<td><a href="edit/${list.id}">Edit</a></td>
						<td><a href="delete/${list.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
	</div>
</body>
</html>

