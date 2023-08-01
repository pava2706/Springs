<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="studentDto.StudentMarks"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch For Remove</title>
<style type="text/css">
body, html {
	margin: 0px;
	padding: 0px;
	background-color: silver;
}

nav {
	padding-top: 100px;
	padding-left: 300px;
}

table {
	font-size: 20px;
	background-color: white;
}

tr {
	border: 4px solid black;
}

#n, h1 {
	color: rgb(red blue green);
	background-color: orange;
	font-size: 40px;
	font-family: monospace;
	letter-spacing: 10px;
	text-shadow: rgb(red white orange);
	font-family: monospace;
	letter-spacing: 10px;
}

div {
	background-color: green;
}
</style>

</head>
<body>
	<%
	List<StudentMarks> l1 = (List<StudentMarks>) request.getAttribute("studentlist");
	%>

	<div>
		<marquee behavior="scroll" direction="right" scrollamount="15" id="n">
			<h1>KARNATAKA SECONDARY EXAMINATION BOARD</h1>
		</marquee>
	</div>

	<nav>
		<table border="5px">
			<tr>
				<th>Register_No</th>
				<th>Name</th>
				<th>Remove</th>
			</tr>
			<%
			for (StudentMarks a : l1) {
			%>
			<tr>
				<td><%=a.getRegister_No()%></td>
				<td><%=a.getName()%></td>
				<td><a href="delete?id=<%=a.getRegister_No()%>">remove</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</nav>
	<a href="kseeb.html" style="font-size: 30px;">Back To KSEEB</a>

</body>
</html>