<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>
<%
String iid=request.getParameter("id");
int id=Integer.parseInt(iid);
MedPlusBean medplus=new MedPlusBean();
medplus.setId(id);
int flag=MedPlusDAO.deleteusermed(medplus);
if(flag>0){
response.sendRedirect("userHome.jsp");
}
else{
	response.sendRedirect("error.html");
}
%>
