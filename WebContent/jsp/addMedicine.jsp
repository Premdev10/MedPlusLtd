<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.medplus.bean.MedPlusBean" %>
    <%@page import="com.medplus.dao.MedPlusDAO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Prescription</title>
	<link rel="stylesheet" type="text/css" href="../css/prescription.css">
	<script src="optionvalidation.js"></script>
</head>
<body>
<%String username=(String)session.getAttribute("uname");
String password=(String)session.getAttribute("password");
MedPlusBean medplus=new MedPlusBean();
medplus.setUname(username);
medplus.setPassword(password);
int i=MedPlusDAO.getUserId(medplus);
System.out.println(i);
%>
<div class="simple-form">
		<h1 class="text">MEDICINE DETAILS</h1>
		<form id="registration" action="medicineInsert.jsp" method="post">
			<input type="text" name="medicinename" placeholder="Medicine name" id="button"><br>
			<br>
			<%-- <select id="time" name="time" style="width:273px;height:30px">
			<option name="time" value="<%=0 %>">Choose an option</option>
			<option name="time" value="ONCE">ONCE</option>
			<option name="time" value="TWICE">TWICE</option>
			<option name="time" value="THRICE">THRICE</option>
			</select><br><br> --%>
			<input type="number" name="times" placeholder=" usage per day" id="button"><br>
			<br>
			
			<input type="text" name="quantity" placeholder="Total Quantity" id="button"><br>
			<br>
			<input type="hidden" name="id" value="<%=i %>">
			
			<input type="submit" value="submit"  id="butt" onclick="return validateoption()">




		</form>
	</div>

</body>
</html>