<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
  <h1>Add New User</h1>  
<form action="register" method="post">
<table>
<tr>    
<!--             <td><input type="hidden" name="id"></td> -->
</tr>
<tr>    
          <td>Name : </td>   <td><input type="text" name="name"></td>
</tr>
<tr>    
          <td>Email : </td>   <td><input type="email" name="email"><br><span style="color: red">${msg}</span></td>
</tr>
<tr>    
          <td>Contact : </td>   <td><input type="number" name="contact"></td>
</tr>
<tr>    
          <td>Password : </td>   <td><input type="password" name="password"></td>
</tr>
<tr>    
          <td></td>   <td><input type="submit" value="Register"></td>
</tr>
</table>
<a href="users">Get Registered Users List</a>
<span style="color: green">${msg2}</span>

</form>
</div>
</body>
</html>