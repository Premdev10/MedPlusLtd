<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.medplus.bean.MedPlusBean" %>
    <%@ page import="com.medplus.bean.SignUpBean" %>
<%@ page import="com.medplus.dao.SignUpDAO" %>
<%@ page import="com.medplus.dao.MedPlusDAO" %>
<%
String uname=request.getParameter("username");
String password=request.getParameter("password");
String medname=request.getParameter("medicinename");
String time=request.getParameter("times");
String uquantity=request.getParameter("quantity");
int quantity=Integer.parseInt(uquantity);
String id=request.getParameter("id");
int iid=Integer.parseInt(id);
MedPlusBean medplus=new MedPlusBean();
medplus.setMedicinename(medname);
medplus.setTime(time);
medplus.setQuantity(quantity);
medplus.setUname(uname);
medplus.setPassword(password);
medplus.setId(iid);
int i=MedPlusDAO.getUserId(medplus);
if(i>0){

int flag=MedPlusDAO.insertMedicine(medplus);
if(flag>0){
	response.sendRedirect("userHome.jsp");
}
else{
	response.sendRedirect("error,html");
}
}

%>
