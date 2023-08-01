
<%@page import="studentDto.StudentMarks"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marks Card</title>
<style type="text/css">
body, html {
	margin: 0px;
	padding: 0px;
	background-image:
		url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRG37KPT5JTN1c2SLFuiSyATVxQHdpIyyCPO43ylUmj&s");
	background-repeat: no-repeat;
	background-size: 100%;
}

nav {
	padding-left: 1px;
	border: 20px solid orange;
}

h1 {
	font-size: 28px;
	font-family: cursive;
	font: bold;
}

h2 {
	font-family: cursive;
	font-style: oblique;
	text-transform: capitalize;
	color: orange;
}

table {
	width: 100%;
	border-bottom-color: 10px black;
}

.tab {
	text-align: center;
}

span {
	padding-left: 100px;
}

button {
	background-color: maroon;
	font-size: 20px;
	color: white;
}
</style>

</head>
<body>
	<%
	StudentMarks a = (StudentMarks) request.getAttribute("studentmarks");
	%>
	<nav>

		<h4 align="center">
			<b>GOVERNMENT OF KARNATAKA</b>
		</h4>
		<h1 align="center">
			<b>Karnataka Secondary Examination Board</b>
		</h1>
		<h2 align="center">
			<b>Marks Statement cum Certificate</b>
		</h2>
		<p align="center">
			<b>This is to certify that the below mentioned candidate has
				passed S.S.L.C. Examination.</b>
		</p>
		<table style="border: 1px solid" border="1px" cellspacing="0px"
			cellpadding="10px">
			<tr>
				<td>Register No : <b><%=a.getRegister_No()%></b></td>
				<td>Month-Year : <b>APRIL-2023</b></td>
			</tr>
			<tr>
				<td>Medium of Instruction : <b>ENGLISH</b></td>
				<td>Candidate Type : <b>CCE REGULAR FRESH</b></td>
			</tr>
		</table>

		<p style="padding-left: 5px;">
			Name:<b style="text-transform: uppercase; letter-spacing:2px;padding-left: 5px; "><%=a.getName()%></b>
		</p>
		<p style="padding-left: 5px;">
			Father's Name:<b style="text-transform: uppercase; letter-spacing:2px;padding-left: 5px;"><%=a.getFather_Name()%></b>
		</p>
		<table style="border: 1px solid" border="1px" cellspacing="0px"
			cellpadding="10px">
			<tr>
				<td>Date of Birth : <b><%=a.getDate_of_Birth()%>
						TWO-THOUSAND-ONE-JUNE-TWENTY-SEVEN</b></td>
				<td>Gender : <b style="text-transform: uppercase;"><%=a.getGender()%></b></td>
			</tr>
		</table>

		<p align="center">PART-A</p>

		<table style="border: 1px solid" border="1px" cellspacing="0px"
			cellpadding="10px" class="tab">
			<tr>
				<td width="300px;">
				<td colspan="3" align="center">EXTERNAL <br>EXAMINATION
				</td>
				<!-- <td>2</td> -->
				<!-- <td>3</td> -->
				<td colspan="3" align="center">TOTAL MARKS</td>
				<!-- <td>2</td> -->
				<!-- <td>3</td> -->
			</tr>
			<tr>
				<td>SCHOLASTIC SUBJECTS</td>
				<td>MAX MARKS</td>
				<td>MIN MARKS</td>
				<td>MARKS OBTAINED</td>
				<td>MAX MARKS</td>
				<td>MIN MARKS</td>
				<td>TOTAL MARKS</td>
			</tr>

			<tr>
				<td>KANNADA</td>
				<td>100</td>
				<td>35</td>
				<td><b><%=a.getKannada()%></b></td>
				<td>125</td>
				<td>44</td>
				<td><b><%=a.getKannada()%></b></td>
			</tr>

			<tr>
				<td>ENGLISH</td>
				<td>80</td>
				<td>28</td>
				<td><b><%=a.getEnglish()%></b></td>
				<td>100</td>
				<td>35</td>
				<td><b><%=a.getEnglish()%></b></td>
			</tr>

			<tr>
				<td>HINDI</td>
				<td>80</td>
				<td>28</td>
				<td><b><%=a.getHindi()%></b></td>
				<td>100</td>
				<td>35</td>
				<td><b><%=a.getHindi()%></b></td>
			</tr>

			<tr>
				<td>MATHEMATICS</td>
				<td>80</td>
				<td>28</td>
				<td><b><%=a.getMathematics()%></b></td>
				<td>100</td>
				<td>35</td>
				<td><b><%=a.getMathematics()%></b></td>
			</tr>

			<tr>
				<td>SCIENCE</td>
				<td>80</td>
				<td>28</td>
				<td><b><%=a.getScience()%></b></td>
				<td>100</td>
				<td>35</td>
				<td><b><%=a.getScience()%></b></td>
			</tr>

			<tr>
				<td>SOCIAL SCIENCE</td>
				<td>80</td>
				<td>28</td>
				<td><b><%=a.getSocialScience()%></b></td>
				<td>100</td>
				<td>35</td>
				<td><b><%=a.getSocialScience()%></b></td>
			</tr>

			<tr>
				<td>TOTAL MARKS</td>
				<td>500</td>
				<td>175</td>
				<td><b><%=a.getTotal_Marks()%></b></td>
				<td>625</td>
				<td>219</td>
				<td><b><%=a.getTotal_Marks()%></b></td>
			</tr>
			<tr>
				<td colspan="6">PERCENTAGE</td>
				<!-- <td>2</td> -->
				<!-- <td>3</td> -->
				<!-- <td>2</td> -->
				<!-- <td>3</td> -->
				<!-- <td>2</td> -->
				<!-- <td>2</td> -->
				<td><b>(<%=a.getPercentage()%>)
				</b></td>
			</tr>
		</table>

		<p align="center">PART-B</p>
		<table style="border: 1px solid" border="1px" cellspacing="0px"
			cellpadding="10px" class="tab">
			<tr>
				<td>SL.NO</td>
				<td>CO-SCHOLASTIC SUBJECTS</td>
				<td>GRADE</td>
				<td>SL.NO</td>
				<td>CO-SCHOLASTIC SUBJECTS</td>
				<td>GRADE</td>
			</tr>

			<tr>
				<td>1.</td>
				<td>PHYSICAL AND HEALTH EDUCATION</td>
				<td>A</td>
				<td>2.</td>
				<td>ATTITUDE AND VALUES</td>
				<td>A</td>
			</tr>

			<tr>
				<td>3.</td>
				<td>WORK EXPERIENCE</td>
				<td>A</td>
				<td>4.</td>
				<td>ART EDUCATION</td>
				<td>A</td>
			</tr>

		</table>
		<br> <span><button>KSEEB KSEEB KSEEB KSEEB KSEEB
				KSEEB KSEEB KSEEB KSEEB KSEEB KSEEB KSEEB KSEEB KSEEB KSEEB KSEEB</button></span>
		<p style="font-size: 20px; padding-left: 20px;">
			Date: <b>29-05-2023</b>
		</p>

		<p style="font-size: 20px; padding-left: 1000px;">
			<b>SECRETARY</b>
		</p>
		<p align="right">
			<b>KARNATAKA SECONDARY EDUCATION EXAMINATION BOARD</b>
		</p>
		<p style="font-size: 20px; padding-left: 1000px;">
			<b>BENGALURU</b>
		</p>


	</nav>
</body>
</html>