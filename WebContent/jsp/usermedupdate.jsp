<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>
<html>
<head>
<% String once=request.getParameter("once");
int one=Integer.parseInt(once);
System.out.println(one);

MedPlusBean medplus=new MedPlusBean();
String medname=request.getParameter("id");
session.setAttribute("medicinename",medname);
System.out.print("require name"+" "+medname);


int total=one;


int newQuantity=MedPlusDAO.getQuantity(medname);
//int newQuantity=quanties.getQuantity();

//int oldQuantity=quanties.getOldquantity();
newQuantity=newQuantity-total;
double percentage=MedPlusDAO.percentagemed(newQuantity,medname);
%><a href='pillRemainder.jsp?perc="<%=percentage%>"'></a>
<%

//session.setAttribute("perc",percentage);
%>
<input type="hidden" id="perc" value="<%=percentage %>">
<%

 int update=MedPlusDAO.updateQuantity(newQuantity, medname);


 if(update>0){
	// System.out.print("quantities"+" "+newQuantity+" "+oldQuantity);
	 
	 //System.out.println("new one"+" "+percentage);
	 //if(percentage<15){
		 
	
		response.sendRedirect("pillRemainder.jsp");
	 }
		
		%>
			
		
		
		
	 
 
 
 


