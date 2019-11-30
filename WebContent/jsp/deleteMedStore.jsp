<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>
<%@ page import="com.medplus.dao.DBDAO" %>
<%@ page import="java.util.*" %>
<%
String iid=request.getParameter("id");
int id=Integer.parseInt(iid);
MedPlusBean medplus=new MedPlusBean();
medplus.setId(id);
int i=MedPlusDAO.deletemedstore(medplus);
if(i>0){
response.sendRedirect("viewMedStoreDet.jsp");
}
else{
response.sendRedirect("error.html");
}
%>