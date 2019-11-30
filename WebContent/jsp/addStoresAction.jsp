<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.medplus.bean.Location" %>
<%@page import="com.medplus.dao.LocationDAO" %>
<%
String storename=request.getParameter("storename");
String longi=request.getParameter("longitude");
double longitude=Double.parseDouble(longi);
String lat=request.getParameter("lattitude");
double lattitude=Double.parseDouble(lat);
String place=request.getParameter("place");
Location storedet=new Location(storename,place,0.0);
storedet.setStorename(storename);
storedet.setPlace(place);


Location location=new Location(longitude,lattitude);
int i=LocationDAO.insertMedStore(location,storedet);
if(i>0){
	response.sendRedirect("viewMedStoreDet.jsp");
}

%>