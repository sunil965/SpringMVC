<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>registration</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">

$(document).ready(function() {
	$("#email").change(function(){
		var email = $("#email").val();
		var obj={};
		obj.email=email;
		
		$.ajax({
			url:"verifyMail",
			type: "POST",
			data : obj,
			success: function(response){
				console.log(response);
				if(response=="yes")
					{
						$("#status").text("email exist....");
					}
				else
					{
						$("#status").text("OK");
					}
			},
			error : function(e){
				alert("error :: "+e);
			} 
		});
	});
});

</script>

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
					<td><form:input path="name"/></td>
					<td id="color"><form:errors path="name" /></td>

				</tr>
				<tr>
					<td>Email :</td>
					<td><form:input path="email" id="email"/><br> <span style="color: red">${msg}</span></td>
					<td id="color"><form:errors path="email" /><div id="status"></div></td>

				</tr>
				<tr>
					<td>Contact :</td>
					<td><form:input path="contact"/></td>
					<td id="color"><form:errors path="contact"/></td>

				</tr>
				<tr>
					<td>Password :</td>
					<td><form:password path="password" /></td>
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