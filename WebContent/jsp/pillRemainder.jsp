<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.medplus.bean.*"%>
<%@page import="com.medplus.dao.MedPlusDAO"%>
<%@ page import="java.util.ArrayList"%>
<%@include file="header.html"%>
<%
	int id = (int) session.getAttribute("id");
	System.out.println("id is" + id);

	MedPlusBean medplus = new MedPlusBean();
	medplus.setId(id);

	ArrayList<MedPlusBean> re = MedPlusDAO.remainder(id);
	
%>

<html>
<head>
<script type="text/javascript" src="percentage.js"></script></head></html>


<title>Insert title here</title>
</head>

<style>
<%@include file="../css/pill.css"%>
</style>

<body>
<% 
//String percentage=(String)session.getAttribute("perc");
//double perct=Double.parseDouble(percentage);
//System.out.println(perct);
%>


	<div class="simple-form">
		<h1 class="text">Remainder form</h1>
		<table class="check">

			<%
				for (MedPlusBean it : re) {
			%>
			<form id="registration" action="usermedupdate.jsp" method="post">
				<tr>

					<td class="textmed"><%=it.getMedicinename()%></td>
					<%int times=Integer.parseInt(it.getTime());
					for(int i=1; i<=times; i++){%>
					

					<td><input type="checkbox" name="once" value="<%="1"%>">
						<%-- <input type="hidden" name="once" value="<%="0"%>"></td> --%>
						<%} %>

					



					<td><input type="hidden" name="id" value="<%=it.getMedicinename()%>"> 
					<td><input type="submit" value="done" id="butt" onclick="return percentagecheck()"></td>
					
				</tr>
				<br>
				
			</form>
			<%
				}
			%>





		</table>
	</div>








	<%
		int iid = (int) session.getAttribute("id");

		ArrayList<MedPlusBean> uv = MedPlusDAO.userMedView(iid);

		int size = 0;
		size = uv.size();
		if (size == 0) {
	%>
	<h3 align="center">NO DATA TO SHOW</h3>
	<%
		} else {
	%>

	<table class="content-table">
		<thead>
			<tr>
				<th>Sl.No</th>
				<th>MEDICINE NAME</th>

				<th>QUANTITY</th>
				<th>ACTION</th>
				<th>ACTION</th>


			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;

					for (MedPlusBean it : uv) {
			%>


			<tr>
				<td><%=i++%></td>
				<td><%=it.getMedicinename()%></td>
				<td><%=it.getQuantity()%></td>
				<td><form name="buttn" action="updateusermed.jsp" method="post">
						<input type="hidden" name="id" value="<%=it.getId()%>"> <input
							type="hidden" name="medname" value="<%=it.getMedicinename()%>">
						<input type="submit" value="edit">
					</form></td>
				<td><form name="buttn" action="deleteusermed.jsp" method="post">
						<input type="hidden" name="id" value="<%=it.getId()%>"> 
						<input type="submit" value="delete">
					</form></td>





			</tr>

			<%
				}
		}
			%>




		</tbody>




	</table>



</body>
</html>

