<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.medplus.dao.ExecuteTimer" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>MED PLUS</title>
	
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="../css/doctorhome.css">
	
</head>
<%
ExecuteTimer exe=new ExecuteTimer(); 
exe.main(new String[] {"some", "arguments"});
String uname=(String)session.getAttribute("uname");

%>
<body>
	<header>
		<div class="main">
			<div class="logo">
				<img src="../images/logo.png">
			</div>
			<ul>
				<li class="active"><a href="#">HOME</a></li>
				<li><a href="aboutUs.html">ABOUT</a></li>
				<li><a href="contactUs.html">CONTACT</a></li>
				<li><a href="logout.jsp">LOGOUT</a></li>
			</ul>
		</div>
		</header>
		<div class="text" style="top:10%">
			<div style="padding-bottom:5%;">		
				<marquee><h3>WELCOME <%=uname %></h3></marquee>
			</div>
			
			<div class="container" style="margin-top:-6%">
  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="top:65%; width:105%">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" style="top:25%">
      <div class="item active">
        <img src="../images/user1.jpg" alt="Los Angeles" style="width:100%; height:396px">
      </div>

      <div class="item">
        <img src="../images/user2.jpg" alt="Chicago" style="width:100%; height:396px">
      </div>
    
      <div class="item">
        <img src="../images/user3.jpg" alt="New york" style="width:100%; height:396px">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
		 
		<div class="button1" style="padding-top:50px;margin-left:230px">
			
			<a href="pillRemainder.jsp" class="btn" >PILL REMAINDER</a>
			<a href="location.jsp" class="btn">LOCATE STORES</a>
			<a href="addMedicine.jsp" class="btn">ADD MEDICINE</a>
			
		</div>

</div>
<%@include file="footer.html" %>

	</body>