<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.medplus.bean.MedPlusBean" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>



<%
String uname=request.getParameter("uname");
session.setAttribute("uname",uname);
String password=request.getParameter("password");
session.setAttribute("password",password);

MedPlusBean medplus=new MedPlusBean();

medplus.setUname(uname);
medplus.setPassword(password);
int i=MedPlusDAO.getUserId(medplus);
session.setAttribute("id",i);

int flag=MedPlusDAO.check(medplus);
if(flag==1){
	response.sendRedirect("adminhome.jsp");
}
else if(flag==2){
	
	response.sendRedirect("userHome.jsp");
}
else if(flag==3){
	
	response.sendRedirect("doctorhome.html");
}
else if(flag==4){
	
	response.sendRedirect("storeHome.jsp");
}
else {
	
	response.sendRedirect("error.html");
}





%>