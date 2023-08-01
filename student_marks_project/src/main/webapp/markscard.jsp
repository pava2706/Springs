<%@page import="java.util.List"%>
<%@page import="studentDto.StudentMarks"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch Details</title>
<style type="text/css">
body, html {
	margin: 0px;
	padding: 0px;
	background-color: silver;
}

nav {
	padding-top: 100px;
	padding-left: 90px;
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
		<table border="10px">
			<tr>
				<th>Register_No</th>
				<th>Name</th>
				<th>DOB</th>
				<th>Father_name</th>
				<th>Gender</th>
				<th>Kannada</th>
				<th>English</th>
				<th>Hindi</th>
				<th>Mathematics</th>
				<th>Science</th>
				<th>SocialScience</th>
				<th>Total_Marks</th>
				<th>Percentage</th>
			</tr>
			<%
			for (StudentMarks a : l1) {
			%>
			<tr>
				<td><%=a.getRegister_No()%></td>
				<td><%=a.getName()%></td>
				<td><%=a.getDate_of_Birth()%></td>
				<td><%=a.getFather_Name()%></td>
				<td><%=a.getGender()%></td>
				<td><%=a.getKannada()%></td>
				<td><%=a.getEnglish()%></td>
				<td><%=a.getHindi()%></td>
				<td><%=a.getMathematics()%></td>
				<td><%=a.getScience()%></td>
				<td><%=a.getSocialScience()%></td>
				<td><%=a.getTotal_Marks()%></td>
				<td><%=a.getPercentage()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</nav>
	<br>
	<a href="kseeb.html" style="font-size: 30px;">Back To KSEEB</a>

</body>
</html>