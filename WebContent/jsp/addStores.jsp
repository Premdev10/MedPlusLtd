<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>Prescription</title>
	<link rel="stylesheet" type="text/css" href="..//css/prescription.css">
</head>
<body>
<div class="simple-form">
		<h1 class="text" style="margin-left:450px">ADD MEDICALSHOPS</h1>
		<form id="registration" action="addStoresAction.jsp" method="post">
			<input type="text" name="storename" placeholder="storename" id="button"><br>
			<br>
			<input type="text" name="longitude" placeholder="longitude" id="button"><br>
			<br>
			<input type="text" name="lattitude" placeholder="lattitude" id="button"><br>
			<br>
			<input type="text" name="place" placeholder="place" id="button"><br>
			<br>
			<input type="submit" value="submit"  id="butt">




		</form>
	</div>

</body>
</html>