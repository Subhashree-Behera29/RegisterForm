<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background:#9B2A8C;

}
.container{
width: 100px;
height: 250px;
border: 20px solid dark;
}
</style>
</head>
<body> 
<div class="container">
	<form action="submitform" method="post">
		<label>Name:</label><input type="text" name=myname> 
		<label>Email:</label><input type="email" name=myemail> 
		<label>Password</label><input type="password" name=mypassword> 
		<label>Gender:</label>Male<input type="radio" name="mygender" value="male">Female<input type="radio" name="mygender" value="female">
		<label>City</label><select name="mycity">
			<option>Select City</option>
			<option>Koraput</option>
			<option>Cuttack</option>
			<option>Puri</option>
		</select>
		<input type="submit" value="Register">
	</form>
</div>
</body>
</html>