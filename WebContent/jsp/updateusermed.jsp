<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.html" %> 


<html>
<head>


<title>update StockDetails</title>
<link rel="stylesheet" type="text/css" href="../css/updateStock.css">


</head>
<body>
<div class="simple-form">
		<h1 class="text">EDIT STOCK FORM</h1>
<form id="updateuser" action="updateUserMedAction.jsp" method="post">
<%  String iid=request.getParameter("id");

session.setAttribute("id",iid);%>



<table class="login-box" >

<tr><td>
<input type="text" name="quantity" placeholder="enter quantity" id="button"></td></tr>
		
		 <tr><td>
		<input type="submit" value="submit"  id="butt">
		</td></tr>
	</table>
</form>
</div>

</body>
</html>


