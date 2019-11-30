<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.medplus.bean.SignUpBean" %>
<%@ page import="com.medplus.dao.SignUpDAO" %>
   <%
   String name=request.getParameter("name");
   String password=request.getParameter("password");
   String place=request.getParameter("place");
   String email=request.getParameter("mail");
   String age=request.getParameter("age");
  
   String mobile=request.getParameter("mobile");
   String role=request.getParameter("role");
   String uname=request.getParameter("username");
   SignUpBean signup=new SignUpBean();
   signup.setName(name);
   signup.setPassword(password);
   signup.setPlace(place);
   signup.setEmail(email);
   signup.setAge(age);
   signup.setMobno(mobile);
   signup.setRole(role);
   signup.setUname(uname);
   int i=SignUpDAO.insertSignUp(signup);
   if(i>0){
	   int id=SignUpDAO.getUserId(signup);
	    
	   signup.setId(id);
	   		
	   			int k=SignUpDAO.insertLogin(signup);
	   			if(k>0){
	   				response.sendRedirect("index.html");
	   			}
	   	
   }else{
	   response.sendRedirect("error.html");
	   
   }
   
   %>
   
