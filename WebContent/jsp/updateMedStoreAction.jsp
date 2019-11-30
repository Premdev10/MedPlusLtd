<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>
<%
String iid=(String)session.getAttribute("id");
int id=Integer.parseInt(iid);
String medname=request.getParameter("pname");
System.out.println("name"+medname);
String longit=request.getParameter("longi");
double longittude=Double.parseDouble(longit);
System.out.println("kittiyo"+longittude);
String latti=request.getParameter("latti");
double lattitude=Double.parseDouble(latti);
String place=request.getParameter("place");
MedPlusBean medplus=new MedPlusBean();
medplus.setId(id);
medplus.setName(medname);
medplus.setLongittude(longittude);
medplus.setLattitude(lattitude);
medplus.setPlace(place);
int flag=MedPlusDAO.updateMedstore(medplus);
if(flag>0){
	response.sendRedirect("viewMedStoreDet.jsp");
}
else{
	response.sendRedirect("error.html");
}
%>

