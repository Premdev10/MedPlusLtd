<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.medplus.bean.*" %>
<%@page import="com.medplus.dao.MedPlusDAO" %>
  <%@ page import="java.util.ArrayList" %>
   <%@include file="header.html"%>
   <%@ page import="com.medplus.bean.Location"%>
<%@ page import="com.medplus.dao.LocationDAO" %>
 
<%


ArrayList<MedPlusBean> ns=MedPlusDAO.nearStore();

  MedPlusBean medplus=new MedPlusBean();

 		int size=0;
 		size=ns.size();
      if(size==0){%>
    	  <h3 align="center">NO DATA TO SHOW</h3>
      <% }else{%>
      <html>
      <style><%@include file="../css/table.css"%>
      <%@include file="../css/location.css"%>
      
     </style>
     <script type="text/javascript" src="location.js"></script>
     
      
     <body>
     <table class="content-table">
     <thead>
     <tr>
     <th>Sl.No</th>
     <th>MEDICAL STORE</th>
	 
     <th>PLACE</th> 
     
    
     </tr>
     </thead>
     <tbody>
      <%
 		int i=1;
      
 			for(MedPlusBean it:ns){

 			
  
                %>
 
 
    <tr><td><%=i++ %></td>
	<td ><%=it.getUname()%></td>
	<td><%=it.getPlace()%></td>
	


	
	</tr>
  
  <% } 
 			}%>
 			<%
 			//String store=(String)session.getAttribute("store");
 			//System.out.println("store enthyi"+store);
 			//String location=(String)session.getAttribute("loc");
 			
int id=(Integer)session.getAttribute("id");
//int id=Integer.parseInt(iid);
//int id=2;
MedPlusBean medplusbean=new MedPlusBean();





Location nearestLocation=LocationDAO.getStoreLocation(id);
// String storeplace=medplusbean.getStoreplace();
String storename=nearestLocation.getStorename();
System.out.println("hello"+storename);
//session.setAttribute("store",storename);

String location=nearestLocation.getPlace();
//session.setAttribute("loc",location);%>
     
     
     
     
     </tbody>
     
     
     
     
     </table>
<body style="text-align:center">

<div class="popup" >Do you want to find nearest location<br>
<br>
<input class="sub" type="submit" value="click here" onclick="myFunction()">
  <span class="popuptext" id="myPopup"><%="Nearest medicalstore:"+" "+storename+" "+"Place:"+" "+location%></span><br>
  
</div>
</body>
     </html>
     