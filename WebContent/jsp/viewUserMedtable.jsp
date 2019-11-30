<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>
  <%@ page import="java.util.ArrayList" %>
  <%@include file="header.html" %>
 
<%
out.println("SUCCESSFULLY UPDATED");
%>
<a href="userHome.jsp">VIEW TABLE</a>