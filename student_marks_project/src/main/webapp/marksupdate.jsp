<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE</title>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	background-color: silver;
}

h1 {
	font-family: cursive;
	color: graytext;
	font-weight: bold;
}

#form {
	background-color: rgba(222, 1, 135, 0.254);
	height: 50px;
	font-size: 20px;
	border-radius: 8px;
	text-align: center;
}

.btn {
	background-color: green;
	border-radius: 8px;
	color: white;
	width: 90%;
	text-align: center;
	font-size: 20px;
}
</style>
</head>
<body>
	<h1 align="center">Update Student Details</h1>
	<hr>
	<form action="update" method="post">
		<table id="form" align="center">
			<tr>
				<th>Register_No :</th>
				<td><input type="text" name="regno"
					value="<%=request.getParameter("regno")%>" readonly="readonly"></td>
			</tr>

			<tr>
				<th>Name :</th>
				<td><input type="text" name="name"
					value="<%=request.getParameter("name")%>"></td>
			</tr>

			<tr>
				<th>DOB :</th>
				<td><input type="date" name="dob"
					value="<%=request.getParameter("dob")%>"></td>
			</tr>

			<tr>
				<th>Father_name :</th>
				<td><input type="text" name="father"
					value="<%=request.getParameter("father")%>"></td>
			</tr>
			<tr>
				<th>Gender :</th>
				<td>
					<%
					if (request.getParameter("gen").equals("male")) {
					%> male:<input
					type="radio" name="gender" value="male" checked="checked">
					female:<input type="radio" name="gender" value="female"> <%
 } else {
 %>
					male:<input type="radio" name="gender" value="male">
					female:<input type="radio" name="gender" value="female"><br>
					<%
					}
					%>
				</td>
			</tr>

			<tr>
				<th>Kannada :</th>
				<td><input type="number" name="kannada" max="100"
					value="<%=request.getParameter("kan")%>"></td>
			</tr>

			<tr>
				<th>English :</th>
				<td><input type="number" name="english" max="80"
					value="<%=request.getParameter("eng")%>"></td>
			</tr>

			<tr>
				<th>Hindi :</th>
				<td><input type="number" name="hindi" max="80"
					value="<%=request.getParameter("hindi")%>"></td>
			</tr>

			<tr>
				<th>Mathematics :</th>
				<td><input type="number" name="maths" max="80"
					value="<%=request.getParameter("math")%>"></td>
			</tr>

			<tr>
				<th>Science :</th>
				<td><input type="number" name="science" max="80"
					value="<%=request.getParameter("science")%>"></td>
			</tr>

			<tr>
				<th>SocialScience :</th>
				<td><input type="number" name="social" max="80"
					value="<%=request.getParameter("social")%>"></td>
			</tr>

			<tr>
				<td>
					<button type="submit" class="btn">Update</button>
				</td>
				<td><button type="reset" class="btn">Clear</button></td>
			</tr>
		</table>
	</form>

	<a href="kseeb.html" style="font-size: 30px;">Back To KSEEB</a>
</body>
</html>