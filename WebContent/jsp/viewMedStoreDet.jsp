<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.html" %>
    <%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>
  <%@ page import="java.util.ArrayList" %>
  <%
  ArrayList<MedPlusBean> uv=MedPlusDAO.medStoreView();

  MedPlusBean medplus=new MedPlusBean();

 		int size=0;
 		size=uv.size();
      if(size==0){%>
    	  <h3 align="center">NO STOCK DETAILS TO SHOW</h3>
      <% }else{%>
      <html>
      <style><%@include file="../css/table.css"%></style>
      
     <body>
     <h1 style="text-align:center; margin-right:180px;color:white">MEDICAL STORES</h1>
     <table class="content-table">
     <thead>
     <tr>
     <th>Sl.No</th>
     <th>MEDICAL SHOP</th>
	 
     <th>LONGITTUDE</th> 
       <th>LATTITUDE</th> 
       <th>PLACE</th>
      <th>Action</th>
      <th>ACTION</th>
     </tr>
     </thead>
     <tbody>
      <%
 		int i=1;
      
 			for(MedPlusBean it:uv){

 			
  
                %>
 
 
    <tr><td><%=i++ %></td>
	<td ><%=it.getStorename()%></td>
	<td ><%=it.getLongittude()%></td>
	<td ><%=it.getLattitude()%></td>
	<td ><%=it.getPlace()%></td>
	
<td><form action="updateMedStore.jsp" method="post">
	<input type="hidden" name="id" value="<%=it.getId() %>">
	<input class="update" type="submit" value="Edit">
	</form> </td>
	<td><form action="deleteMedStore.jsp" method="post">
	<input type="hidden" name="id" value="<%=it.getId() %>">
	<input class="delete" type="submit" value="Delete">
	</form> </td>

	
	</tr>
  
  <% } 
 			}%>
     
     
     
     
     </tbody>
     
     
     
     
     </table>
     
     
     
     </body>
     </html>
  