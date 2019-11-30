package com.medplus.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.medplus.bean.Location;
import com.medplus.bean.MedPlusBean;






public class LocationDAO {
	
	
	
	static int flag=0;
	static Connection con=null;
	static PreparedStatement pst=null;
	static ResultSet rs=null;
	static int id=0;
	static double lat1;
	static double lat2;
	static double lon1;
	static double lon2;
	static double distance=0;
	static double dist=0;
	static Location storeLocation=null ;
	static  Location currentLocation=null;
	static Location storeName=null;
	static String reqName=null;
	static String reqPlace=null;
	static Location storeDetails;
	static int i=0;
	
 

	
	
	
	
	public static Connection getDbConnection()throws SQLException {
		
		try{
			DBDAO.dbConnection();
			con=DBDAO.getDbCon();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
	

    public static Location getCurrentLocation(int id) throws SQLException{
    	System.out.print("flow to the current location");
    	
    	try{
    		con=getDbConnection();
    		
    		pst=con.prepareStatement("select *from tbl_userlocation where reg_id="+id+"");
    		rs=pst.executeQuery();
    		
    		while(rs.next()){
    			lon1=rs.getDouble(2);
    			
    			
    			lat1=rs.getDouble(3);
    			
    			currentLocation = new Location(lon1,lat1);
    		
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return  currentLocation;
    }
    public static Location  getStoreLocation(int id)throws SQLException{
    	
    	 double shortestDistance = -1.0;
     	  double distance=0.0;
     	 System.out.print("into function"+" ");
 		
    	
    	try{
    		Location currentlocation=getCurrentLocation(id);
    		System.out.print("current location longi"+" "+currentlocation.getLongitude());
    		System.out.print("current location lattitude"+" "+currentlocation.getLattitude());
    		ArrayList<Location> lst=new ArrayList<Location>();
    		
    		con=getDbConnection();
    		
    		pst=con.prepareStatement("select * from tbl_storeloc");
    		
    		rs=pst.executeQuery();
    		while(rs.next()){
    			id=rs.getInt(1);
    			
    			lon2=rs.getDouble(3);
    			lat2=rs.getDouble(4);
    			storeLocation=new Location(lon2,lat2);
    		    lst.add(storeLocation);
    		    
   
    			
    		}
    		for(Location location:lst){
    			distance=distance(currentLocation.getLongitude(),location.getLongitude(),currentLocation.getLattitude(),location.getLattitude());
    			
    			if( shortestDistance== -1.0 || shortestDistance>distance){
    				shortestDistance  = distance;
    				
    				storeName=getNameOfStore(location.getLongitude(),location.getLattitude());
    				
    				
    				
 			}
    			
    		}
    		System.out.print( " shortest distance is"+" "+shortestDistance);
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return storeName;
    }
    
    
    
    
    
    public static double distance(double lon1,double lon2,double lat1,double lat2) {
        // haversine great circle distance approximation, returns meters
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60; // 60 nautical miles per degree of seperation
        dist = dist * 1852; // 1852 meters per nautical mile
        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
    public static Location getNameOfStore(double a,double b){
    	//MedPlusBean medplusbean=new MedPlusBean();
    	
    	try{
    		System.out.print("get store longitude"+" "+	a);
        	System.out.print("get store lattitude"+" "+b);
    		con=getDbConnection();
    		pst=con.prepareStatement("select *from tbl_storeloc where st_longitude=? and st_lattitude=?");
 		pst.setDouble(1, b);
  		pst.setDouble(2, a);
//    		
    		rs=pst.executeQuery();
    		while(rs.next()){
    			String storename=rs.getString(2);
    			String storeplace=rs.getString(5);
    			double awayfrom=0;
    			storeDetails=new Location(storename,storeplace,awayfrom);
    			
               // medplusbean.setStorename(rs.getString(2));
               // reqPlace=rs.getString(2);
                //medplusbean.setStoreplace(rs.getString(5));
    			
    		
    		}
    		}catch(Exception e){
    		e.printStackTrace();
    	}
    	System.out.print("store name is"+" "+reqName);
    	return storeDetails;
    }
    
    
    public static int insertMedStore(Location location,Location meddet) throws SQLException{
		 
		  try{
			  con=getDbConnection();
			  pst=con.prepareStatement("insert into tbl_storeloc(ST_UNAME,ST_LONGITUDE,ST_LATTITUDE,ST_PLACE) values(?,?,?,?)");
			  pst.setString(1, meddet.getStorename());
			  pst.setDouble(2,location.getLongitude());
			  pst.setDouble(3,location.getLattitude());
			  pst.setString(4,meddet.getPlace());
			  
			 
			  i=pst.executeUpdate();
			  
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  return i;
	  }
   
}