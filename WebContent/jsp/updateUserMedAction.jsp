<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>

<%
String medname=(String)session.getAttribute("medicinename");
String iid=(String)session.getAttribute("id");
int id=Integer.parseInt(iid);


System.out.println("new id"+" "+id);
String quant=request.getParameter("quantity");
int quantity=Integer.parseInt(quant);

int newQuantity=MedPlusDAO.getQuantity(medname);
newQuantity+=quantity;
System.out.println("new quant"+newQuantity);
MedPlusBean medplus=new MedPlusBean();
medplus.setQuantity(newQuantity);


int up=MedPlusDAO.updateuserMed(id, newQuantity);



if(up==1){
	
	response.sendRedirect("viewUserMedtable.jsp");
	
}else{
	response.sendRedirect("error.html");
}
%>