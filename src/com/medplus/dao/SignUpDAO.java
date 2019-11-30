package com.medplus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.medplus.bean.MedPlusBean;
import com.medplus.bean.SignUpBean;
import com.medplus.dao.DBDAO;

public class SignUpDAO {
	private static int i=0;
	private static Connection con=null;
	 private static PreparedStatement pst=null;
 private static ResultSet rs=null;
	public static Connection getDbConnection()throws SQLException {
		
		try{
			DBDAO.dbConnection();
			con=DBDAO.getDbCon();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
 
	
	public static int insertSignUp(SignUpBean signup) throws SQLException{
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("insert into tbl_registration(reg_name,reg_place,reg_mobile,reg_age,reg_email) values(?,?,?,?,?)");
			  pst.setString(1, signup.getName());
			  pst.setString(2,signup.getPlace());
			  pst.setString(3, signup.getMobno());
			  pst.setString(4, signup.getAge());
			  pst.setString(5, signup.getEmail());
			  i=pst.executeUpdate();
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return i;
	  }
	
	
	 public static int  getUserId(SignUpBean signup) throws SQLException{
		 
	 
	    	
	    	
	try{
	            
	            con=getDbConnection();
	        pst=con.prepareStatement("select reg_id from tbl_registration where reg_email='"+signup.getEmail()+"'");
	       rs=pst.executeQuery();
	        while(rs.next()){
	        	
	        	i=rs.getInt(1);
		}
	}catch(Exception e){
			e.printStackTrace();
		}
		System.out.print(i);
		return i;
		
	}
	public static int insertLogin(SignUpBean signup) throws SQLException{
		 
		  try{
			  System.out.print("insert login function");
			  con=getDbConnection();
			  pst=con.prepareStatement("insert into tbl_logintable (l_name,l_password,l_role,reg_id) values(?,?,?,?)");
			  pst.setString(1,signup.getUname());
			  pst.setString(2, signup.getPassword());
			  pst.setString(3, signup.getRole());
			  System.out.print(signup.getId());
			  pst.setInt(4, signup.getId());
			  i=pst.executeUpdate();
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return i;
	  }


}